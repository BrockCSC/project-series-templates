# Project Series Templates Repository
This repository contains templates for different styles of projects that may be freely used for the project series

## NOTES
**NOTE 1:** These templates are strictly for the project series, and any other personal projects you wish to use them in. These templates are not to be used for assignments!

**NOTE 2:** The difficulty of the challenges is based using a first year student's perspective. If you are an upper year student please judge the difficulty for yourself. If there is a problem with the classification we have for a challenge please let us know!

## Getting Started with Github
If you need help getting started with Github, please download our [instructional guide](https://drive.google.com/file/d/0B4JunSkTKIlKZGhuN1lqYUVhYmc/view) and follow the steps.

## Setup
### Java
**Eclipse** (After repository is pulled):
  1. Open Eclipse
  2. Set the workspace to the file directory containing all of the subfolders (RPG Animation Template, etc.)
  3. Select File > New > Java Project
  4. Where it asks for the project name type the name of the template you wish to use (ex. "RPG Animation Template")
  5. The project should now be set up and ready to use

**NetBeans** (After repository is pulled):
  1. Open Netbeans
  2. Go to "File -> Import Project -> Eclipse Project"
  3. Select "Import project ignoring Project Dependencies"
  4. Select the folder containing the program you wish to work on (ex. "MarioMashUp") for the "Project to import"
  5. Choose the destination folder of where you wish to have the converted project as the "Destination Folder"
  6. Right click the project in the projects navigation on the left
  7. Select properties
  8. On the tab that opens up, at the bottom it says "Source/Binary format" Select JDK 8.
  9. Press OK
  10. The project is now set up, but you need to copy over the dependencies (The images, or input files, etc.). This will vary from project to project.
  11. To do this, go to the original folder containing the source files
  12. Copy the missing dependencies (When you run the project, it will tell you what files are missing and you need to locate. For example, for the paint program, you need to copy over the "MenuIcons" folder as it contains the images needed for the project)
  13. Paste the files into the root directory of what you set as the "Destination Folder"
  14. The project should have all the required dependencies, and should be ready to use.

### Other Language
  Please follow the steps in the project folder


## Current Projects
This table is referencing the status of the basic code we are providing

:white_check_mark: - Ready to use

:warning: - In Progress - incomplete but relatively stable

:x: - Not Ready to use


| Project | Language | Status | Entry Point|
| :---: | :---: | :---: | :---: |
| Paint Program Template | Java | :white_check_mark: | Main.java |
| Pixelate | Python | :white_check_mark: | Main.py |
| MarioMashUp | Java | :white_check_mark: | MarioWindow.java |
| RPG Animation Template | Java | :x: | Main.java |


## Problem with the Template?
  Please submit an issue report using the Issues tab at the top of the page. Please look [here](https://github.com/BrockCSC/project-series-templates/issues/5) for an example of the formatting.

### Issue Formatting
  **Title:** [Project Template Name] Descriptive Issue Name
  
  **Leave a comment:** Leave a detailed description of the issue. Examples of things to include are:
  - A detailed decription of what is happening
  - Stack trace if program crashes
  - If you have done some debugging then let us know what your results were
  - Any console output
