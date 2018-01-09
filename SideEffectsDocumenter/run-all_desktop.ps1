# ======== INSTRUCTIONS ========
# In order for this script to work you need the following:
# 1. JDK 1.7 and 1.8
# 2. Purano .jar and the templates folder (both in the zip)
# 3. .jar File or .class Files of the program that you want to analyze
# 4. .jar File of SideEffectsDocumenter
# 5. root-Folder of .java Files from the same program
# ==============================


# ========= SETTINGS =========
# --------- PURANO ---------
$java7 = 'C:\Program Files\Java\jdk1.7.0_79\bin\java' #set to JDK 1.7
$puranoCP = 'C:\Users\Sandro\Documents\GitHub\SideEffectsDocumenter-Experiment\SideEffectsDocumenter\*;' #folder pointing to Purano .jar

# Specify the root path to the .class files or the folder of the .jar file which should be analyzed
# If you want to analyze a jar file, add the path to the file with a '\*' at the end
$homeDir = 'C:\Users\Sandro\Documents\GitHub\SideEffectsDocumenter-Experiment\build\classes\main'

$pkg = 'ch.uzh.ifi.seal' # Specify the package which should be analyzed
$outputPath = 'C:\Users\Sandro\Documents\GitHub\SideEffectsDocumenter-Experiment' # Specify the directory where the purano results should be saved
$templatePath = 'C:\Users\Sandro\Documents\GitHub\SideEffectsDocumenter-Experiment\SideEffectsDocumenter\templates' # Folder of the HTML Templates
$showExtended = False # True = all analyzed classes, False = only user classes in result

# ------- SideEffectsDocumenter SETTINGS -------
$java8 = 'C:\Program Files\Java\jdk1.8.0_20\bin\java' # JDK 1.8 folder
$jar = 'C:\Users\Sandro\Documents\GitHub\SideEffectsDocumenter-Experiment\SideEffectsDocumenter\SideEffects-documenter-all-1.0.jar' # Path to SideEffectsDocumenter .jar

$javaRoot = 'C:\Users\Sandro\Documents\GitHub\SideEffectsDocumenter-Experiment\src\main\java\' # root of .java files
$showExtended = True # True = detailed info, False = just Purity info
$ioBlacklistPath = 'C:\Users\Sandro\Documents\GitHub\SideEffectsDocumenter-Experiment\SideEffectsDocumenter\IO_blacklist.txt'
$replaceOriginalFiles = True

# ======== End of Settings ========
# =================================


# Run Purano (do not change something here)
$purano = 'jp.ac.osakau.farseerfc.purano.reflect.ClassFinder'
$puranoPath = $outputPath + '\Purano-Result.json'
$cp = $puranoCP + $homeDir
$doRunPurano = True
if($showExtended) 
{
    & $java7 -cp $cp $purano --pkg $pkg -o $outputPath -t $templatePath --extended
}
else 
{
    & $java7 -cp $cp $purano --pkg $pkg -o $outputPath -t $templatePath
}



# Second: start SideEffectsDocumenter
$main = 'main.Main'
& $java8 -jar $jar $javaRoot -p $puranoPath -e $showExtended -io $ioBlacklistPath -r $replaceOriginalFiles -l -t