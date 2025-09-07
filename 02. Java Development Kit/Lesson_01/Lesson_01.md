
# Урок 1. Графические интерфейсы


### План урока:

- создание окна;
- менеджеры размещений;
- элементы графического интерфейса;
- обработчики событий.

## Практическое задание

### Задание 1 

Задача: Полностью разобраться с кодом.


### Задание 2 

Задача: Переделать проверку победы, чтобы она не была реализована просто набором условий.

```
    private boolean checkWin(int c) {

        int sizeWin;
        int diag1 = 0, diag2 = 0, diag3 = 0, diag4 = 0, diag5 = 0, diag6 = 0;

        if (size > 3) {
            sizeWin = size - 1;
            for (int y = 1; y < size; y++) { // проверка победителя по диагонали, если поле больше, чем 3х3
                if (field[y][y-1] == c) diag3++;
                if (field[y-1][y] == c) diag4++;
                if (field[y-1][size - 1 - y] == c) diag5++;
                if (field[y][size - y] == c) diag6++;
            }
        } else {
            sizeWin = size;
        }

        for (int x = 0; x < size; x++) {    // проверка победителя по строкам и столбцам
            int row = 0, column = 0;
            for (int y = 0; y < size; y++) {
                if (field[x][y] == c) column++;
                if (field[y][x] == c) row++;
            }
            if (column == sizeWin || row == sizeWin) return true;
        }
        for (int x = 0; x < size; x++) {   // проверка победителя по диагонали
            if (field[x][x] == c) diag1++;
            if (field[x][size - 1 - x] == c) diag2++;
        }
        return diag1 == sizeWin || diag2 == sizeWin || diag3 == sizeWin || diag4 == sizeWin || diag5 == sizeWin || diag6 == sizeWin;
    }
```


### Задание 3 

Задача: Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фигур 4.

```
    Решение соответствует заданию № 2.
```

### Задание 4**

Задача: Доработать искусственный интеллект, чтобы он мог примитивно блокировать ходы игрока, и примитивно пытаться выиграть сам (решение заимствовано из презентации к семинару).

```
    private void aiTurn() {
        if (turnAIWnCell()) return;
        if (turnHumanWinCell()) return;

        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }


    private boolean turnAIWnCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = AI_DOT;
                    if (checkWin(AI_DOT)) return true;
                    field[i][j] = EMPTY_DOT;
                }
            }
        }
        return false;
    }


    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = HUMAN_DOT;
                    if (checkWin(HUMAN_DOT)) {
                        field[i][j] = HUMAN_DOT;
                        return true;
                    }
                    field[i][j] = EMPTY_DOT;
                }
            }
        }
        return false;
    }
```