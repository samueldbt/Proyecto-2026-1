import geckodriver_autoinstaller
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

geckodriver_autoinstaller.install()
#Coded by Branlol
options = webdriver.FirefoxOptions()
options.set_preference("dom.webdriver.enabled", False)
driver = webdriver.Firefox(options=options)
wait = WebDriverWait(driver, 15)

driver.get("https://www.uis.edu.co/estudiantesWebJ8/pages/academico/consultarAsignaturaProgramada.jsf")
print("Inicia sesión manualmente y presiona ENTER aquí...")
input()

materia = input("¿Qué materia quieres buscar? (ej: calculo, o si quiere todas solo ponga 4 espacios jajaja ")

search_box = driver.find_element(By.ID, "form:txtNombreAsignatura")
search_box.clear()
search_box.send_keys(materia)
driver.find_element(By.ID, "form:btnConsultaAsignatura").click()

wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, "#form\\:dtlListadoProgramadas_data tr")))

rows = driver.find_elements(By.CSS_SELECTOR, "#form\\:dtlListadoProgramadas_data tr")
total = len(rows)
print(f"✅ {total} grupos encontrados. Descargando horarios...")

results = []

for i, row in enumerate(rows):
    cols = row.find_elements(By.TAG_NAME, "td")
    if len(cols) < 5:
        continue

    codigo_materia = cols[0].text.strip()
    nombre = cols[1].text.strip()
    grupo = cols[2].text.strip()
    capacidad = cols[3].text.strip()
    matriculados = cols[4].text.strip()

    try:
        btn_ver = cols[5].find_element(By.TAG_NAME, "button")
        driver.execute_script("arguments[0].click();", btn_ver)

        wait.until(EC.visibility_of_element_located(
            (By.CSS_SELECTOR, "#formHorario\\:dtlListadoParciales_data tr")
        ))

        horario_rows = driver.find_elements(
            By.CSS_SELECTOR, "#formHorario\\:dtlListadoParciales_data tr"
        )

        for hrow in horario_rows:
            hcols = hrow.find_elements(By.TAG_NAME, "td")
            if len(hcols) < 5:
                continue

            dia = hcols[0].text.strip()
            hora = hcols[1].text.strip()
            edificio = hcols[2].text.strip()
            aula = hcols[3].text.strip()
            profesor = hcols[4].text.strip()

            if " - " in hora:
                hora_inicio, hora_fin = hora.split(" - ")
            else:
                hora_inicio, hora_fin = hora, "N/A"

            results.append([
                codigo_materia, grupo, capacidad, profesor, nombre,
                dia, hora_inicio.strip(), hora_fin.strip(),
                edificio, aula, matriculados
            ])

        close_btn = driver.find_element(
            By.CSS_SELECTOR, "#formHorario\\:j_idt83 .ui-dialog-titlebar-close"
        )
        driver.execute_script("arguments[0].click();", close_btn)

        wait.until(EC.invisibility_of_element_located(
            (By.CSS_SELECTOR, "#formHorario\\:dtlListadoParciales_data tr")
        ))

        print(f"[{i+1}/{total}] {nombre} - {grupo} ✓")

    except Exception as e:
        print(f"[{i+1}/{total}] {nombre} - {grupo} ✗ Error: {e}")
        results.append([
            codigo_materia, grupo, capacidad, "N/A", nombre,
            "N/A", "N/A", "N/A", "N/A", "N/A", matriculados
        ])

driver.quit()

nombre_archivo = f"resultado_{materia.replace(' ', '_')}.txt"
with open(nombre_archivo, "w", encoding="utf-8") as f:
    f.write("codigo_materia,grupo,capacidad,profesor,materia,dia,hora_inicio,hora_fin,edificio,salon,matriculados\n")
    for r in results:
        f.write(",".join(r) + "\n")

print(" Guardado en {nombre_archivo}")
