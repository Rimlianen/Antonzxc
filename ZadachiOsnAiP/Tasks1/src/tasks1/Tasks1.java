package tasks1;

import static java.awt.SystemColor.text;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anton Kuznetsov 21-ИС-1
 *
 *
 * @docRoot
 *
 *Чтобы запустить программу нажмите на кнопку нажмите на кнопку Start
 */
public class Tasks1 extends javax.swing.JFrame {

    DefaultTableModel tm = new DefaultTableModel();
//    private static String text = "";
    private static String fileName = "";
//    private static File file = new File(fileName);

    public void PR4Zad34() {

        fileName = txtfWayToSaveTheFile.getText() + txtfSaveFileName.getText() + ".txt";
        DefaultListModel<String> list1 = new DefaultListModel();
        Studients[] array = new Studients[5];  //массив студентов
        String[] Familie = {"Смирнов", "Петрова", "Киселёв", "Попов", "Брагина"}; //массив фамилий студентов
        String[] Imya = {"Аким", "Юлия", "Иван", "Евгений", "Дарья"}; //массив имён студентов
        String[] Otchestvo = {"Алексеевич", "Владимировна", "Александрович", "Николаевич", "Артёмовна"}; //массив отчества студентов
        String[] Pol = {"Мальчик", "Девочка", "Мальчик", "Мальчик", "Девочка"}; //массив пола студентов
        int[] Rost = {172, 156, 195, 154, 162};//Массив роста всех людей

        for (int i = 0; i < 5; i++) { //создаёт объект учащихся
            Studients human = new Studients(Imya[i], Familie[i], Otchestvo[i], Pol[i], Rost[i]);
            array[i] = human;
            list1.addElement((i + 1) + ". " + human.getImya() + " " + human.getFamilie() + " " + human.getOtchestvo() + " " + human.getPol() + " " + human.getRost() + " - Рост");
        }
        ListTasks.setModel(list1); //выводит в лист
        double GirlRost = 0;
        int girlCount = 0;
        for (int i = 0; i < Familie.length; i++) { //считает количество девочек
            if (array[i].getPol() == "Девочка") {
                GirlRost += array[i].getRost();
                girlCount++;
            }

        }
        if (girlCount > 0) { //если есть девочки, считаем средний рост
            lblSredn.setText("Средний рост девочек:" + GirlRost / girlCount);
        } else {
            lblSredn.setText("Нет данных о девочках");
        }

//Вывод работников в лист, возможность ввести путь для файла и его создания 
        ListTasks.setModel(list1);
        if (rbtnSaveAnswer.isSelected()) {
            if (txtfWayToSaveTheFile.getText().isEmpty() || txtfSaveFileName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Поле пусто, введите значения!");
            } else {
                String text = "Средний рост девочек: " + GirlRost / girlCount + "";
                fileName = txtfWayToSaveTheFile.getText() + txtfSaveFileName.getText() + ".txt";
                tasks1.Files.save(fileName, text);

                lblOutFileSaved.setText("Файл сохранён " + "(" + fileName + ")");
            }
        }

    }

    public void PR3Zad59() {
        String text = TextVvod.getText(); //получение вводимого текста в строку
        if (TextVvod.getText().isEmpty()) { //проверка строки на пустоту
            JOptionPane.showMessageDialog(rootPane, "Строка не должна быть пуста");
        } else {
            String input = TextVvod.getText();
            String output = rmvSpaces(input);
            outputText.setText(output);

        }
    }

    private String rmvSpaces(String input) {
        return input.replaceAll("\\s+", "");
    }

    public void PR3Zad34() {
        String input = Vvodrandom.getText(); //получаем введенную строку
        if (Vvodrandom.getText().isEmpty()) { //проверка строки на пустоту
            JOptionPane.showMessageDialog(rootPane, "Строка не должна быть пуста");
        } else {
            int min = Integer.MAX_VALUE; //создаём переменную мин.цифры и инициализируем её значением, большим, чем любая цифра
            for (int i = 1; i < input.length(); i += 2) { //перебираем символы на чётных позициях, начиная с 1
                char current = input.charAt(i); ///получаем текущий символ строки
                if (Character.isDigit(current)) { //проверяем является ли текущий символ цифрой
                    int curDigit = Character.getNumericValue(current); //преобразуем текущий символ в цифру
                    if (curDigit < min) { //сравниваем текущую цифру с минимальной цифрой
                        min = curDigit; //Если текущая цифра меньше, обновляем минимальную цифру
                    }

                }

            }
            if (min == Integer.MAX_VALUE) { //если мин.цифру так и не нашли то:
                lblOtsut.setText("Цифры на чётных позициях отсутствуют"); //выводим сообщение

            } else {
                lblOtsut.setText("Наименьшая цифра на чётных позициях:" + min); //выводим найденную минимальную цифру
            }
        }
    }

    public void PR3Zad9() {
        String text = VvodTexta.getText(); //получение вводимого текста в строку
        if (VvodTexta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Строка не должна быть пуста");
            //   lblresullt.setVisible(false);

        } else {
            String[] words = text.split("\\s+"); //Разбиение текста на отдельные слова с помощью \\s+
            String lengths = "";
            for (String word : words) {
                lengths = lengths + " " + word + " - " + word.length();
            }
            lblresullt.setText(lengths); //вывод результата
        }
    }

    public void PR21() {                              //Код на случай того, если нужно будет добавить поля для ввода!
//        if (TEXTStrok1.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(rootPane, "Строка не должна быть пуста");
//
//        } else {
//            if (TEXTStolb1.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(rootPane, "Строка не должна быть пуста");
//            } else {
//                String input = TEXTStrok1.getText();
//
//                // Проверка наличия цифр
//                boolean containsDigit = false;
//                for (char c : input.toCharArray()) {
//                    if (Character.isDigit(c)) {
//                        containsDigit = true;
//                        break;
//                    }
//                }
//                // Если введена буква, выводится диалоговое окно с просьбой ввести цифру
//                if (containsDigit) {
//                    System.out.println("Строка содержит цифры.");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Введите цифру.", "Ошибка", JOptionPane.ERROR_MESSAGE);}
        tm = (DefaultTableModel) TableMatrix.getModel();
        int row = 10; //Переменная строк
        int col = 8; //перемененая столбцов
        tm.setColumnCount(col);

        int[][] matrix = new int[10][8]; // размер матрицы 
        //заполняем матрицу случайными числами
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            Vector vr = new Vector();
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = rnd.nextInt(31) + 19;
                vr.add(matrix[i][j]);
            }
            tm.addRow(vr);
        }
        //Находим минимальный элемент в каждом столбце
        int[] mins = new int[8];
        for (int j = 0; j < 8; j++) {
            int min = matrix[0][j];
            for (int i = 1; i < 10; i++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            mins[j] = min;
        }
        //Выбираем максимальный минимальный элемент
        int maxMin = mins[0];
        for (int i = 0; i < 8; i++) {
            if (mins[i] > maxMin) {
                maxMin = mins[i];
            }

        }
        lblMaxElemStolbec.setText(Arrays.toString(mins) + " "); //выводим минимальные элементы из каждого столбца на экран
        lblMaxMin.setText(maxMin + " ");  //выводим максимальный из минимальных элементов на экран
    }

    public void PR2() {
        VvodMatrix.getText(); //получение текста с поля ввода
        {
            //проверка на пустую строку
            if (VvodMatrix.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Строка не должна быть пуста");

            } else {

                int n = Integer.parseInt(VvodMatrix.getText());
                tm = (DefaultTableModel) Table1.getModel();
                //создание целочисленных переменных
                int row = (n);
                int col = (n);
                tm.setColumnCount(col); //устанавливает кол-во столбцов в объекте
                int[][] matrix = new int[n][n]; //создание новой матрицы NxN
                //заполняем матрицу случайными числами
                Random random = new Random();
                for (int i = 0; i < n; i++) {
                    Vector vr = new Vector();
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = random.nextInt(10);
                        vr.add(matrix[i][j]);
                    }
                    tm.addRow(vr);
                }
                //находим суммы строк
                int[] rowSums = new int[n];
                for (int i = 0; i < n; i++) {
                    int sum = 0;
                    for (int j = 0; j < n; j++) {
                        sum += matrix[i][j];
                    }
                    rowSums[i] = sum;
                }
                //находим индекс строки с максимальной суммой
                int maxIndex = 0;
                for (int i = 1; i < n; i++) {
                    if (rowSums[i] > rowSums[maxIndex]) {
                        maxIndex = i;
                    }

                }
                //выводим результаты на экран
                lblRezu1.setText(" ");
                lblRezu.setText(Integer.toString(maxIndex + 1));
                for (int j = 0; j < n; j++) {
                    lblRezu1.setText(lblRezu1.getText() + matrix[maxIndex][j] + " ");

                }
                int sum1 = 0;
                for (int i : matrix[maxIndex]) {
                    sum1 += i;

                }
                lblMatSum.setText(+sum1 + " "); //вывод суммы матрицы
            }
        }
    }

    public void sss() {
        //генерируем случайный массив из 10 чисел от 1 до 100
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        lblIsxMas.setText(Arrays.toString(arr) + " "); //выводим исходный массив на экран
        int maxIndex = 0; //создаём переменную макс.элемента
        //находим индекс максимального элемента
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        Arrays.fill(arr, maxIndex + 1, arr.length, 0); //заменяем элементы после макс.числа на нули
        lblmaxElem.setText(arr[maxIndex] + " "); //выводим макс.элемент на экран 
        lblIzmMas.setText(Arrays.toString(arr) + " "); //выводим изменённый массив

    }

    public void life() {
        //генерируем случайный массив из 6 чисел от 1 до 9
        int[] A = new int[6];
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(19) - 9;
        }
        lblMasElem.setText(Arrays.toString(A) + " "); //выводим массив на экран
        int count = 0; //счётчик положительных элементов
        for (int i = 0; i < A.length; i++) {
            //если число больше нуля, то счётчик положительных элементов +1
            if (A[i] > 0) {
                count++;
            }
        }
        lblPolozj.setText(count + " "); //выводим количество положительных элементов на экран
    }

    public void Doma() {
        //генерируем случайный массив из 20 чисел от 1 до 5000
        int[] payments = new int[20];
        for (int i = 0; i < payments.length; i++) {
            payments[i] = (int) (Math.random() * 5000 + 1);
            lblMasElem2.setText(Arrays.toString(payments) + " ");
        }
        int sum = 0; //общая сумма платежей
        String notPaid = " "; //номера квартир,которые не оплатили ком.услуги
        String paymentExceeded = " "; //номера квартир, платежи которых превысили заданное значение

        int maxPayment = 3000; //заданное значение для поиска переплат
        for (int i = 0; i < payments.length; i++) {
            //вычисляем общую сумму платежей
            sum += payments[i];
            //проверяем, оплатила ли квартира ком.услуги (если нет, то добавляем ёё номер в строку)
            if (payments[i] < maxPayment) {
                notPaid += (i + 1) + " ";
            }
            //проверяем, превысила ли плата за месяц заданное значение (если да, то добавляем номер кв. в строку)
            if (payments[i] > maxPayment) {
                paymentExceeded += (i + 1) + " ";
            }
        }
        //выводим результаты на экран
        lblKvar.setText(maxPayment + ":" + paymentExceeded + " ");
        lblObshSum.setText(sum + " ");
        lblNotPaid.setText(notPaid + " ");
    }

    public Tasks1() {
        initComponents();
        txtfWayToSaveTheFile.setVisible(false);
        txtfSaveFileName.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        razdel1 = new javax.swing.JPanel();
        task9 = new javax.swing.JTabbedPane();
        panel9 = new javax.swing.JPanel();
        lblTask9 = new javax.swing.JLabel();
        lblIsxMasTEXT = new javax.swing.JLabel();
        lblIsxMas = new javax.swing.JLabel();
        btnStart1 = new javax.swing.JButton();
        lblmaxElemTEXT = new javax.swing.JLabel();
        lblmaxElem = new javax.swing.JLabel();
        lblIzmTEXT = new javax.swing.JLabel();
        lblIzmMas = new javax.swing.JLabel();
        panel34 = new javax.swing.JPanel();
        lblTask34 = new javax.swing.JLabel();
        btnStart2 = new javax.swing.JButton();
        lblMasElementsTEXT = new javax.swing.JLabel();
        lblMasElem = new javax.swing.JLabel();
        lblPolozjElementsTEXT = new javax.swing.JLabel();
        lblPolozj = new javax.swing.JLabel();
        panel59 = new javax.swing.JPanel();
        lblZadacha59Raz1 = new javax.swing.JLabel();
        btnStart3 = new javax.swing.JButton();
        lblMasElements2TEXT = new javax.swing.JLabel();
        lblMasElem2 = new javax.swing.JLabel();
        lblNomeraKvartirinfo = new javax.swing.JLabel();
        lblKvar = new javax.swing.JLabel();
        lblObshSumTEXT = new javax.swing.JLabel();
        lblObshSum = new javax.swing.JLabel();
        lblNotPaidTEXT = new javax.swing.JLabel();
        lblNotPaid = new javax.swing.JLabel();
        razdel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Panel9raz2 = new javax.swing.JPanel();
        lblTEXTZADACHA9R2 = new javax.swing.JLabel();
        btStart9r2 = new javax.swing.JButton();
        ScrollPanelmatrix = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        lblTRWmSI = new javax.swing.JLabel();
        lblRezu = new javax.swing.JLabel();
        lblRezu1 = new javax.swing.JLabel();
        lblMatrixSum = new javax.swing.JLabel();
        lblMatSum = new javax.swing.JLabel();
        VvodMatrix = new javax.swing.JTextField();
        lblVvodMatrix = new javax.swing.JLabel();
        Panel34raz2 = new javax.swing.JPanel();
        TEXTZAD3RAZ2lbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableMatrix = new javax.swing.JTable();
        btnPR232 = new javax.swing.JButton();
        lblMaxElementsStolbecTXT = new javax.swing.JLabel();
        lblMaxInMinElemTXT = new javax.swing.JLabel();
        lblMaxElemStolbec = new javax.swing.JLabel();
        lblMaxMin = new javax.swing.JLabel();
        razdel3 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        PalelZadacha9 = new javax.swing.JPanel();
        lblresullt = new javax.swing.JLabel();
        btnStart6 = new javax.swing.JButton();
        VvodTexta = new javax.swing.JTextField();
        lblVvodTexta = new javax.swing.JLabel();
        lblRaz3Zadanie9 = new javax.swing.JLabel();
        PalelZadacha34 = new javax.swing.JPanel();
        lblRaz3Zadacha34 = new javax.swing.JLabel();
        Vvodrandom = new javax.swing.JTextField();
        lblInfoRAZ3ZAD34 = new javax.swing.JLabel();
        btnStartRaz3Zad34 = new javax.swing.JButton();
        lblOtsut = new javax.swing.JLabel();
        PalelZadacha59 = new javax.swing.JPanel();
        lblRaz3Zadacha59 = new javax.swing.JLabel();
        TextVvod = new javax.swing.JTextField();
        outputText = new javax.swing.JLabel();
        btnStart8 = new javax.swing.JButton();
        razdel4 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblZadacha34Raz4text = new javax.swing.JLabel();
        btnStartRaz4Zad34 = new javax.swing.JButton();
        ScrollPanel = new javax.swing.JScrollPane();
        ListTasks = new javax.swing.JList<>();
        lblSredn = new javax.swing.JLabel();
        txtfWayToSaveTheFile = new javax.swing.JTextField();
        lblAdressSoxr = new javax.swing.JLabel();
        txtfSaveFileName = new javax.swing.JTextField();
        lblFileName = new javax.swing.JLabel();
        rbtnSaveAnswer = new javax.swing.JRadioButton();
        lblOutFileSaved = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mbarFile = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mbarEdit = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTask9.setText("В заданном массиве найти максимальный элемент. Элементы, стоящие после максимального элемента заменить нулями.");

        lblIsxMasTEXT.setText("Исходный массив:");

        lblIsxMas.setText("0");

        btnStart1.setText("Start");
        btnStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart1ActionPerformed(evt);
            }
        });

        lblmaxElemTEXT.setText("Максимальный элемент:");

        lblmaxElem.setText("0");

        lblIzmTEXT.setText("Изменённый массив:");

        lblIzmMas.setText("0");

        javax.swing.GroupLayout panel9Layout = new javax.swing.GroupLayout(panel9);
        panel9.setLayout(panel9Layout);
        panel9Layout.setHorizontalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStart1))
                    .addGroup(panel9Layout.createSequentialGroup()
                        .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTask9)
                            .addGroup(panel9Layout.createSequentialGroup()
                                .addComponent(lblIsxMasTEXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIsxMas))
                            .addGroup(panel9Layout.createSequentialGroup()
                                .addComponent(lblmaxElemTEXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblmaxElem))
                            .addGroup(panel9Layout.createSequentialGroup()
                                .addComponent(lblIzmTEXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIzmMas)))
                        .addGap(0, 354, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel9Layout.setVerticalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTask9)
                .addGap(33, 33, 33)
                .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsxMasTEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIsxMas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblmaxElem)
                    .addComponent(lblmaxElemTEXT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIzmTEXT)
                    .addComponent(lblIzmMas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
                .addComponent(btnStart1)
                .addContainerGap())
        );

        task9.addTab("Задача 9", panel9);

        lblTask34.setText("Заполнить массив А[1..6] числами, вводимыми с клавиатуры. Найти количество положительных элементов.");

        btnStart2.setText("Start");
        btnStart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart2ActionPerformed(evt);
            }
        });

        lblMasElementsTEXT.setText("Элементы массива:");

        lblMasElem.setText("0");

        lblPolozjElementsTEXT.setText("Кол-во положительных элементов:");

        lblPolozj.setText("0");

        javax.swing.GroupLayout panel34Layout = new javax.swing.GroupLayout(panel34);
        panel34.setLayout(panel34Layout);
        panel34Layout.setHorizontalGroup(
            panel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel34Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStart2))
                    .addGroup(panel34Layout.createSequentialGroup()
                        .addGroup(panel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTask34)
                            .addGroup(panel34Layout.createSequentialGroup()
                                .addComponent(lblMasElementsTEXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMasElem))
                            .addGroup(panel34Layout.createSequentialGroup()
                                .addComponent(lblPolozjElementsTEXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPolozj)))
                        .addGap(0, 433, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel34Layout.setVerticalGroup(
            panel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTask34)
                .addGap(27, 27, 27)
                .addGroup(panel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMasElementsTEXT)
                    .addComponent(lblMasElem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPolozjElementsTEXT)
                    .addComponent(lblPolozj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                .addComponent(btnStart2)
                .addContainerGap())
        );

        task9.addTab("Задача 34", panel34);

        lblZadacha59Raz1.setText("<html>В одномерном массиве хранится информация о коммунальных платежах каждой из семей 20-квартирного дома за месяц.<p> Определить: а) общую сумму платежей; б) номера квартир, которые не оплатили коммунальные услуги; <p> в) номера квартир, платежи которых превысили заданное значение.</html>");

        btnStart3.setText("Start");
        btnStart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart3ActionPerformed(evt);
            }
        });

        lblMasElements2TEXT.setText("Elements:");

        lblMasElem2.setText("0");

        lblNomeraKvartirinfo.setText("Номера квартир которые привысили платёж");

        lblKvar.setText("0");

        lblObshSumTEXT.setText("Общая сумма:");

        lblObshSum.setText("0");

        lblNotPaidTEXT.setText("Номера квартир которые не оплатили ком.услуги:");

        lblNotPaid.setText("0");

        javax.swing.GroupLayout panel59Layout = new javax.swing.GroupLayout(panel59);
        panel59.setLayout(panel59Layout);
        panel59Layout.setHorizontalGroup(
            panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel59Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStart3))
                    .addGroup(panel59Layout.createSequentialGroup()
                        .addGroup(panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblZadacha59Raz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel59Layout.createSequentialGroup()
                                .addComponent(lblMasElements2TEXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMasElem2))
                            .addGroup(panel59Layout.createSequentialGroup()
                                .addComponent(lblNomeraKvartirinfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblKvar))
                            .addGroup(panel59Layout.createSequentialGroup()
                                .addComponent(lblObshSumTEXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblObshSum))
                            .addGroup(panel59Layout.createSequentialGroup()
                                .addComponent(lblNotPaidTEXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNotPaid)))
                        .addGap(0, 355, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel59Layout.setVerticalGroup(
            panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblZadacha59Raz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMasElements2TEXT)
                    .addComponent(lblMasElem2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKvar)
                    .addComponent(lblNomeraKvartirinfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObshSum)
                    .addComponent(lblObshSumTEXT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNotPaidTEXT)
                    .addComponent(lblNotPaid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(btnStart3)
                .addContainerGap())
        );

        task9.addTab("Задача 59", panel59);

        javax.swing.GroupLayout razdel1Layout = new javax.swing.GroupLayout(razdel1);
        razdel1.setLayout(razdel1Layout);
        razdel1Layout.setHorizontalGroup(
            razdel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(razdel1Layout.createSequentialGroup()
                .addComponent(task9)
                .addContainerGap())
        );
        razdel1Layout.setVerticalGroup(
            razdel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(task9, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Раздел1", razdel1);

        lblTEXTZADACHA9R2.setText("Дана матрица NхN. Вывести на экран дисплея элементы той строки, сумма элементов которой максимальна.");

        btStart9r2.setText("Start");
        btStart9r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStart9r2ActionPerformed(evt);
            }
        });

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Столбец 1", "Столбец 2", "Столбец 3", "Столбец 4", "Столбец 5", "Столбец 6", "Столбец 7"
            }
        ));
        ScrollPanelmatrix.setViewportView(Table1);

        lblTRWmSI.setText("The row with max sum is:");

        lblRezu.setText("0");

        lblMatrixSum.setText("Matrix sum: ");

        lblMatSum.setText("0");

        VvodMatrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VvodMatrixActionPerformed(evt);
            }
        });
        VvodMatrix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                VvodMatrixKeyTyped(evt);
            }
        });

        lblVvodMatrix.setText("Введите матрицу");

        javax.swing.GroupLayout Panel9raz2Layout = new javax.swing.GroupLayout(Panel9raz2);
        Panel9raz2.setLayout(Panel9raz2Layout);
        Panel9raz2Layout.setHorizontalGroup(
            Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel9raz2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                        .addComponent(lblTEXTZADACHA9R2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                        .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblRezu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScrollPanelmatrix, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                        .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel9raz2Layout.createSequentialGroup()
                                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Panel9raz2Layout.createSequentialGroup()
                                                .addComponent(lblMatrixSum)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblMatSum))
                                            .addGroup(Panel9raz2Layout.createSequentialGroup()
                                                .addComponent(lblTRWmSI, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblRezu))))
                                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(lblVvodMatrix)
                                        .addGap(18, 18, 18)
                                        .addComponent(VvodMatrix, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel9raz2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btStart9r2)
                                .addGap(184, 184, 184))))))
        );
        Panel9raz2Layout.setVerticalGroup(
            Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel9raz2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                        .addComponent(lblTEXTZADACHA9R2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPanelmatrix, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                            .addGroup(Panel9raz2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(VvodMatrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblVvodMatrix))
                                .addGap(49, 49, 49)
                                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTRWmSI)
                                    .addComponent(lblRezu))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMatrixSum)
                                    .addComponent(lblMatSum))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblRezu1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btStart9r2)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Задача 9", Panel9raz2);

        TEXTZAD3RAZ2lbl.setText("<html>Вывести на экран матрицу 10x8, элементами которой являются целые случайные числа из интервала [19,49]. <p> Определить минимальный элемент в каждом столбце и выбрать из них максимальный.");

        TableMatrix.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Столбец 1", "Столбец 2", "Столбец 3", "Столбец 4", "Столбец 5", "Столбец 6", "Столбец 7", "Столбец 8", "Столбец 9", "Столбец 10"
            }
        ));
        jScrollPane3.setViewportView(TableMatrix);

        btnPR232.setText("Start");
        btnPR232.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPR232ActionPerformed(evt);
            }
        });

        lblMaxElementsStolbecTXT.setText("Минимальный элемент в каждом столбце:");

        lblMaxInMinElemTXT.setText("Максимальный из минимальных элементов:");

        lblMaxElemStolbec.setText("0");

        lblMaxMin.setText("0");

        javax.swing.GroupLayout Panel34raz2Layout = new javax.swing.GroupLayout(Panel34raz2);
        Panel34raz2.setLayout(Panel34raz2Layout);
        Panel34raz2Layout.setHorizontalGroup(
            Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel34raz2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(btnPR232)
                .addGap(35, 35, 35))
            .addGroup(Panel34raz2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TEXTZAD3RAZ2lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel34raz2Layout.createSequentialGroup()
                        .addComponent(lblMaxElementsStolbecTXT)
                        .addGap(18, 18, 18)
                        .addComponent(lblMaxElemStolbec, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel34raz2Layout.createSequentialGroup()
                        .addComponent(lblMaxInMinElemTXT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMaxMin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel34raz2Layout.setVerticalGroup(
            Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel34raz2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TEXTZAD3RAZ2lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaxElementsStolbecTXT)
                    .addComponent(lblMaxElemStolbec))
                .addGap(18, 18, 18)
                .addGroup(Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaxInMinElemTXT)
                    .addComponent(lblMaxMin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(btnPR232)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Задача 34", Panel34raz2);

        javax.swing.GroupLayout razdel2Layout = new javax.swing.GroupLayout(razdel2);
        razdel2.setLayout(razdel2Layout);
        razdel2Layout.setHorizontalGroup(
            razdel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(razdel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        razdel2Layout.setVerticalGroup(
            razdel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Раздел2", razdel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );

        btnStart6.setText("Start");
        btnStart6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart6ActionPerformed(evt);
            }
        });

        VvodTexta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VvodTextaActionPerformed(evt);
            }
        });

        lblVvodTexta.setText("Введите текст:");

        lblRaz3Zadanie9.setText("Определить длину каждого слова из заданного текста (слова разделены пробелами).");

        javax.swing.GroupLayout PalelZadacha9Layout = new javax.swing.GroupLayout(PalelZadacha9);
        PalelZadacha9.setLayout(PalelZadacha9Layout);
        PalelZadacha9Layout.setHorizontalGroup(
            PalelZadacha9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PalelZadacha9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PalelZadacha9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRaz3Zadanie9, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PalelZadacha9Layout.createSequentialGroup()
                        .addComponent(lblVvodTexta)
                        .addGap(18, 18, 18)
                        .addComponent(VvodTexta, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblresullt, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PalelZadacha9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStart6)
                .addGap(47, 47, 47))
        );
        PalelZadacha9Layout.setVerticalGroup(
            PalelZadacha9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PalelZadacha9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRaz3Zadanie9)
                .addGap(18, 18, 18)
                .addGroup(PalelZadacha9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVvodTexta)
                    .addComponent(VvodTexta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblresullt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(btnStart6)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Задача 9", PalelZadacha9);

        lblRaz3Zadacha34.setText("Определить наименьшую из цифр, занимающих во введенной строке четные позиции.");

        Vvodrandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VvodrandomActionPerformed(evt);
            }
        });

        lblInfoRAZ3ZAD34.setText("Введите любые цифры:");

        btnStartRaz3Zad34.setText("Start");
        btnStartRaz3Zad34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartRaz3Zad34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PalelZadacha34Layout = new javax.swing.GroupLayout(PalelZadacha34);
        PalelZadacha34.setLayout(PalelZadacha34Layout);
        PalelZadacha34Layout.setHorizontalGroup(
            PalelZadacha34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PalelZadacha34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PalelZadacha34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PalelZadacha34Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStartRaz3Zad34))
                    .addGroup(PalelZadacha34Layout.createSequentialGroup()
                        .addGroup(PalelZadacha34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRaz3Zadacha34)
                            .addGroup(PalelZadacha34Layout.createSequentialGroup()
                                .addComponent(lblInfoRAZ3ZAD34, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Vvodrandom, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblOtsut, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 396, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PalelZadacha34Layout.setVerticalGroup(
            PalelZadacha34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PalelZadacha34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRaz3Zadacha34)
                .addGap(18, 18, 18)
                .addGroup(PalelZadacha34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Vvodrandom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfoRAZ3ZAD34))
                .addGap(55, 55, 55)
                .addComponent(lblOtsut, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(btnStartRaz3Zad34)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Задача 34", PalelZadacha34);

        lblRaz3Zadacha59.setText("Создать процедуру, позволяющую из заданной строки удалить пробелы.");

        TextVvod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextVvodActionPerformed(evt);
            }
        });

        btnStart8.setText("Start");
        btnStart8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PalelZadacha59Layout = new javax.swing.GroupLayout(PalelZadacha59);
        PalelZadacha59.setLayout(PalelZadacha59Layout);
        PalelZadacha59Layout.setHorizontalGroup(
            PalelZadacha59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PalelZadacha59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PalelZadacha59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRaz3Zadacha59)
                    .addComponent(TextVvod, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputText, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PalelZadacha59Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStart8)
                .addGap(150, 150, 150))
        );
        PalelZadacha59Layout.setVerticalGroup(
            PalelZadacha59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PalelZadacha59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRaz3Zadacha59)
                .addGap(29, 29, 29)
                .addComponent(TextVvod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(outputText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(btnStart8))
        );

        jTabbedPane3.addTab("Задача 59", PalelZadacha59);

        javax.swing.GroupLayout razdel3Layout = new javax.swing.GroupLayout(razdel3);
        razdel3.setLayout(razdel3Layout);
        razdel3Layout.setHorizontalGroup(
            razdel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(razdel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        razdel3Layout.setVerticalGroup(
            razdel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(razdel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(razdel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Раздел3", razdel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Задача 9", jPanel4);

        lblZadacha34Raz4text.setText("Создать файл, содержащий данные: ФИО ученика; пол; рост. Просмотреть данные из файла. Определить средний рост девочек.");

        btnStartRaz4Zad34.setText("Start");
        btnStartRaz4Zad34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartRaz4Zad34ActionPerformed(evt);
            }
        });

        ScrollPanel.setViewportView(ListTasks);

        txtfWayToSaveTheFile.setText("D:\\");
            txtfWayToSaveTheFile.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtfWayToSaveTheFileActionPerformed(evt);
                }
            });

            lblAdressSoxr.setText("Введите адрес для сохранения файла:");

            txtfSaveFileName.setText("FileName");
            txtfSaveFileName.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtfSaveFileNameActionPerformed(evt);
                }
            });

            lblFileName.setText("Введите имя файла:");

            rbtnSaveAnswer.setText("Сохранить объект в файл");
            rbtnSaveAnswer.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rbtnSaveAnswerActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblZadacha34Raz4text))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(lblOutFileSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(140, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(txtfWayToSaveTheFile, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78)
                            .addComponent(txtfSaveFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblSredn)
                            .addGap(169, 169, 169)
                            .addComponent(btnStartRaz4Zad34)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbtnSaveAnswer)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblAdressSoxr)
                                    .addGap(80, 80, 80)
                                    .addComponent(lblFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblZadacha34Raz4text)
                    .addGap(30, 30, 30)
                    .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAdressSoxr)
                        .addComponent(lblFileName))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSredn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnStartRaz4Zad34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfWayToSaveTheFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfSaveFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(17, 17, 17)
                    .addComponent(rbtnSaveAnswer)
                    .addGap(53, 53, 53)
                    .addComponent(lblOutFileSaved, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            jTabbedPane4.addTab("Задача 34", jPanel5);

            javax.swing.GroupLayout razdel4Layout = new javax.swing.GroupLayout(razdel4);
            razdel4.setLayout(razdel4Layout);
            razdel4Layout.setHorizontalGroup(
                razdel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(razdel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(192, Short.MAX_VALUE))
            );
            razdel4Layout.setVerticalGroup(
                razdel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(razdel4Layout.createSequentialGroup()
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE))
            );

            jTabbedPane1.addTab("Раздел4", razdel4);

            mbarFile.setText("File");

            jMenuItem1.setText("Выйти");
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem1ActionPerformed(evt);
                }
            });
            mbarFile.add(jMenuItem1);

            jMenuBar1.add(mbarFile);

            mbarEdit.setText("Edit");

            jMenuItem2.setText("Информация");
            jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem2ActionPerformed(evt);
                }
            });
            mbarEdit.add(jMenuItem2);

            jMenuBar1.add(mbarEdit);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnPR232ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPR232ActionPerformed
        tm.setRowCount(0);
        PR21();
    }//GEN-LAST:event_btnPR232ActionPerformed

    private void btStart9r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStart9r2ActionPerformed
        tm.setRowCount(0);
        PR2();
    }//GEN-LAST:event_btStart9r2ActionPerformed

    private void btnStart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart3ActionPerformed
        Doma();
    }//GEN-LAST:event_btnStart3ActionPerformed

    private void btnStart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart2ActionPerformed
        life();
    }//GEN-LAST:event_btnStart2ActionPerformed

    private void btnStart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart1ActionPerformed
        sss();
    }//GEN-LAST:event_btnStart1ActionPerformed

    private void btnStart6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart6ActionPerformed
        PR3Zad9();
    }//GEN-LAST:event_btnStart6ActionPerformed

    private void VvodTextaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VvodTextaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VvodTextaActionPerformed

    private void VvodrandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VvodrandomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VvodrandomActionPerformed

    private void btnStartRaz3Zad34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartRaz3Zad34ActionPerformed
        PR3Zad34();
    }//GEN-LAST:event_btnStartRaz3Zad34ActionPerformed

    private void TextVvodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextVvodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextVvodActionPerformed

    private void btnStart8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart8ActionPerformed
        PR3Zad59();
    }//GEN-LAST:event_btnStart8ActionPerformed

    private void btnStartRaz4Zad34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartRaz4Zad34ActionPerformed

        PR4Zad34();
    }//GEN-LAST:event_btnStartRaz4Zad34ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Разработчик: Кузнецов Антон");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void VvodMatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VvodMatrixActionPerformed


    }//GEN-LAST:event_VvodMatrixActionPerformed

    private void txtfSaveFileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfSaveFileNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfSaveFileNameActionPerformed

    private void txtfWayToSaveTheFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfWayToSaveTheFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfWayToSaveTheFileActionPerformed

    private void rbtnSaveAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSaveAnswerActionPerformed
        if (rbtnSaveAnswer.isSelected()) {//Если включена кнопка, то выполняется
            txtfWayToSaveTheFile.setVisible(true);
            txtfSaveFileName.setVisible(true);
            System.out.println("true");
            lblOutFileSaved.setText("↑");
        } else {
            txtfWayToSaveTheFile.setVisible(false);
            txtfSaveFileName.setVisible(false);
        }
    }//GEN-LAST:event_rbtnSaveAnswerActionPerformed

    private void VvodMatrixKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VvodMatrixKeyTyped
        //проверка на ввод любых символов и букв кроме цифр
        VvodMatrix.getText();
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_VvodMatrixKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tasks1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tasks1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tasks1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tasks1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tasks1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListTasks;
    private javax.swing.JPanel PalelZadacha34;
    private javax.swing.JPanel PalelZadacha59;
    private javax.swing.JPanel PalelZadacha9;
    private javax.swing.JPanel Panel34raz2;
    private javax.swing.JPanel Panel9raz2;
    private javax.swing.JScrollPane ScrollPanel;
    private javax.swing.JScrollPane ScrollPanelmatrix;
    private javax.swing.JLabel TEXTZAD3RAZ2lbl;
    private javax.swing.JTable Table1;
    private javax.swing.JTable TableMatrix;
    private javax.swing.JTextField TextVvod;
    private javax.swing.JTextField VvodMatrix;
    private javax.swing.JTextField VvodTexta;
    private javax.swing.JTextField Vvodrandom;
    private javax.swing.JButton btStart9r2;
    private javax.swing.JButton btnPR232;
    private javax.swing.JButton btnStart1;
    private javax.swing.JButton btnStart2;
    private javax.swing.JButton btnStart3;
    private javax.swing.JButton btnStart6;
    private javax.swing.JButton btnStart8;
    private javax.swing.JButton btnStartRaz3Zad34;
    private javax.swing.JButton btnStartRaz4Zad34;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel lblAdressSoxr;
    private javax.swing.JLabel lblFileName;
    private javax.swing.JLabel lblInfoRAZ3ZAD34;
    private javax.swing.JLabel lblIsxMas;
    private javax.swing.JLabel lblIsxMasTEXT;
    private javax.swing.JLabel lblIzmMas;
    private javax.swing.JLabel lblIzmTEXT;
    private javax.swing.JLabel lblKvar;
    private javax.swing.JLabel lblMasElem;
    private javax.swing.JLabel lblMasElem2;
    private javax.swing.JLabel lblMasElements2TEXT;
    private javax.swing.JLabel lblMasElementsTEXT;
    private javax.swing.JLabel lblMatSum;
    private javax.swing.JLabel lblMatrixSum;
    private javax.swing.JLabel lblMaxElemStolbec;
    private javax.swing.JLabel lblMaxElementsStolbecTXT;
    private javax.swing.JLabel lblMaxInMinElemTXT;
    private javax.swing.JLabel lblMaxMin;
    private javax.swing.JLabel lblNomeraKvartirinfo;
    private javax.swing.JLabel lblNotPaid;
    private javax.swing.JLabel lblNotPaidTEXT;
    private javax.swing.JLabel lblObshSum;
    private javax.swing.JLabel lblObshSumTEXT;
    private javax.swing.JLabel lblOtsut;
    private javax.swing.JLabel lblOutFileSaved;
    private javax.swing.JLabel lblPolozj;
    private javax.swing.JLabel lblPolozjElementsTEXT;
    private javax.swing.JLabel lblRaz3Zadacha34;
    private javax.swing.JLabel lblRaz3Zadacha59;
    private javax.swing.JLabel lblRaz3Zadanie9;
    private javax.swing.JLabel lblRezu;
    private javax.swing.JLabel lblRezu1;
    private javax.swing.JLabel lblSredn;
    private javax.swing.JLabel lblTEXTZADACHA9R2;
    private javax.swing.JLabel lblTRWmSI;
    private javax.swing.JLabel lblTask34;
    private javax.swing.JLabel lblTask9;
    private javax.swing.JLabel lblVvodMatrix;
    private javax.swing.JLabel lblVvodTexta;
    private javax.swing.JLabel lblZadacha34Raz4text;
    private javax.swing.JLabel lblZadacha59Raz1;
    private javax.swing.JLabel lblmaxElem;
    private javax.swing.JLabel lblmaxElemTEXT;
    private javax.swing.JLabel lblresullt;
    private javax.swing.JMenu mbarEdit;
    private javax.swing.JMenu mbarFile;
    private javax.swing.JLabel outputText;
    private javax.swing.JPanel panel34;
    private javax.swing.JPanel panel59;
    private javax.swing.JPanel panel9;
    private javax.swing.JPanel razdel1;
    private javax.swing.JPanel razdel2;
    private javax.swing.JPanel razdel3;
    private javax.swing.JPanel razdel4;
    private javax.swing.JRadioButton rbtnSaveAnswer;
    private javax.swing.JTabbedPane task9;
    private javax.swing.JTextField txtfSaveFileName;
    private javax.swing.JTextField txtfWayToSaveTheFile;
    // End of variables declaration//GEN-END:variables

    private boolean containsDigits(String input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
