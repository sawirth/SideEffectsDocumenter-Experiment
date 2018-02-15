# Task description
### Task 1
The first task represents a test that tests different steps of an entire process. Roughly speaking, it is about creating a product for an online shop and doing different things.
It was noticed that during the test data is written to the productive database which should not happen obviously.
The goal is now to find the location in the code where the access happens and delete it.
To control that the correct changes have been made, the Gradle task `task1` will be run. If it is green the task is finished.

### Task 2
The second task performs certain calculations for prices. It is checked that the prices do not change during the calculations. However, that is exactly what happens. Find the place where that happens and correct it by deleting the modification.
The Gradle task `task2` is then executed for control. If the result is green the task is completed.

# **Important information**
Code inside both task classes must **not** be changed.
You cannot just delete the assert statement :wink:


# IntelliJ IDEA Cheat Sheet
| Action          | Keymap            |
| :-------------  | :-------------          |
| Go To Declaration (go to method)| F12 |
| Switch between open files (navigate with arrow keys) | Alt + Tab |
| Back to the previous location of the cursors | Back key on mouse |
| Find Usages | Right click -> Find Usages or Alt + Shift + F7 |
