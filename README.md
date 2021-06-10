# CSV list limitor
## configuración
En el archivo settings.cfg se configurará el numero de lineas maximo por archivo.

` limit=1400 ` 

el numero a la derecha indica el maximo numero de entradas por archivo, eso sin incluir la linea por el retorno de carro ` \n` al final del archivo.
## Uso:
- entrada, los archivos de entrada se deben introducir en la carpeta input.
- salida, una vez ejecutado los csv ya divididos con la nomenclatura: ` nombre-Original-Sin-Extenxion + "-" + indice-De-Orden + ".csv"`
  
  donde el indice-De-Orden indica de la división del archivo original. 

  A tener en cuenta que si el archivo tiene una longitud inferior o igual al limite configurado, sellamará igual que el original
- ejecución:
  - windows: ejecutar Run.bat
  - Linux: ejecutar Run.sh