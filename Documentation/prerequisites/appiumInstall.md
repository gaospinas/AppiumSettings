# Configuración del Entorno

## Pasos para configurar un entorno de automatización móvil utilizando Appium:

1. **Instalar Node.js**: Appium requiere Node.js. Puedes instalarlo desde [nodejs.org](https://nodejs.org/).
2. **Instalar Appium**: Usa npm para instalar Appium globalmente:
   ```bash
   npm install -g appium
   ```
3. **Instalar Appium Doctor**: Para verificar que todo esté configurado correctamente:
   ```bash
   npm install -g appium-doctor
   appium-doctor
   ```
4. **Instalar Xcode**: Para desarrollo en iOS, necesitas Xcode desde la Mac App Store.
5. **Instalar Android Studio**: Para desarrollo en Android, descarga Android Studio y configura el SDK.
6. **Configurar variables de entorno**: Asegúrate de que las variables de entorno como `JAVA_HOME`, `ANDROID_HOME`, y `PATH` estén correctamente configuradas.
7. **Instalar WebDriverAgent**: Para iOS, necesitas WebDriverAgent, que se instala automáticamente con Appium.
8. **Instalar un emulador o conectar un dispositivo físico**: Para Android, puedes usar Android Emulator, y para iOS, el simulador de Xcode.

## Configurar el iPad físico

1. Conecta tu iPad a tu Mac usando un cable USB.
2. Desbloquea tu iPad y confía en la computadora cuando aparezca la solicitud.
3. Abre Xcode y selecciona tu iPad como dispositivo de destino.
4. Si es la primera vez, Xcode te pedirá habilitar el Modo Desarrollador en el iPad.

## Instalar Homebrew (si no lo tienes)

1. Abre la Terminal.
2. Ejecuta el siguiente comando para instalar Homebrew:
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
3. Verifica la instalación:
   ```bash
   brew --version
   ```

## Instalar Node.js y Appium

1. Instala Node.js usando Homebrew:
   ```bash
   brew install node
   ```
2. Verifica la instalación:
   ```bash
   node --version
   npm --version
   ```
3. Instala Appium globalmente:
   ```bash
   npm install -g appium
   ```
4. Verifica la instalación:
   ```bash
   appium --version
   ```

## Instalar Appium Doctor

1. Instala Appium Doctor:
   ```bash
   npm install -g appium-doctor
   ```
2. Verifica la configuración:
   ```bash
   appium-doctor
   ```

## Configurar las variables de entorno

1. Abre la Terminal.
2. Abre el archivo de configuración de tu shell:
  - Para `zsh`:
    ```bash
    nano ~/.zshrc
    ```
  - Para `bash`:
    ```bash
    nano ~/.bash_profile
    ```
3. Agrega las siguientes líneas:
   ```bash
   # Java (si usas Android)
   export JAVA_HOME=$(/usr/libexec/java_home)
   
   # Android SDK (si usas Android)
   export ANDROID_HOME=$HOME/Library/Android/sdk
   export PATH=$ANDROID_HOME/emulator:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools:$PATH
   
   # Appium
   export PATH=$PATH:/usr/local/bin
   ```
4. Guarda el archivo y recarga la configuración:
  - Para `zsh`:
    ```bash
    source ~/.zshrc
    ```
  - Para `bash`:
    ```bash
    source ~/.bash_profile
    ```

## Instalar Carthage (para WebDriverAgent)

1. Instala Carthage usando Homebrew:
   ```bash
   brew install carthage
   ```

## Configurar WebDriverAgent

1. Clona el repositorio de WebDriverAgent:
   ```bash
   git clone https://github.com/appium/WebDriverAgent.git
   ```
2. Navega al directorio de WebDriverAgent:
   ```bash
   cd WebDriverAgent
   ```
3. Ejecuta el script de bootstrap:
   ```bash
   ./Scripts/bootstrap.sh
   ```
4. Abre el proyecto en Xcode:
   ```bash
   open WebDriverAgent.xcodeproj
   ```
5. En Xcode, selecciona el esquema `WebDriverAgentRunner` y elige tu iPad como dispositivo de destino.
6. Configura el `Team` en la pestaña "Signing & Capabilities".
7. Compila y ejecuta WebDriverAgent en tu iPad.

## Configurar Appium para usar el iPad físico

1. Abre la Terminal y ejecuta Appium:
   ```bash
   appium
   ```
2. Configura las capacidades en tu script de automatización:
   ```python
   from appium import webdriver

   desired_caps = {
       "platformName": "iOS",
       "platformVersion": "16.0",
       "deviceName": "iPad",
       "udid": "<UDID_del_iPad>",
       "app": "/path/to/your/app.ipa",
       "automationName": "XCUITest"
   }

   driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)
   ```
3. Para obtener el UDID de tu iPad, conecta el iPad a tu Mac y abre `Xcode > Window > Devices and Simulators`.

## Ejecutar la prueba

1. Asegúrate de que Appium esté corriendo.
2. Ejecuta tu script de automatización.
3. Observa cómo Appium interactúa con tu iPad físico.

## Resumen de lo que has instalado:

- Xcode.
- Homebrew.
- Node.js y Appium.
- Carthage.
- WebDriverAgent.
- Variables de entorno configuradas.

