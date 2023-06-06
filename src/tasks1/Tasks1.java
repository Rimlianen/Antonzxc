package tasks1;

import static java.awt.SystemColor.text;
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
 * @author Anton Kuznetsov 21-ИС-1 Чтобы запустить программу нажмите на кнопку
 * Start(старт)
 */
public class Tasks1 extends javax.swing.JFrame {

    DefaultTableModel tm = new DefaultTableModel();
    private static String text = "";
    private static String fileName = "";
    private static File file = new File(fileName);

    public void PR4Zad34(int protect) throws IOException {

        fileName = AdresTxt.getText() + FileNametxt.getText() + ".txt";
        DefaultListModel<String> list1 = new DefaultListModel();
        Studients[] array = new Studients[5];
        String[] Familie = {"Смирнов", "Петрова", "Киселёв", "Попов", "Брагина"};
        String[] Imya = {"Аким", "Юлия", "Иван", "Евгений", "Дарья"};
        String[] Otchestvo = {"Алексеевич", "Владимировна", "Александрович", "Николаевич", "Артёмовна"};
        String[] Pol = {"Мальчик", "Девочка", "Мальчик", "Мальчик", "Девочка"};
        int[] Rost = {172, 156, 195, 154, 162};//Массив роста всех людей

        for (int i = 0; i < 5; i++) { //создаёт объект учащихся
            Studients human = new Studients(Imya[i], Familie[i], Otchestvo[i], Pol[i], Rost[i]);
            array[i] = human;
            list1.addElement((i + 1) + ". " + human.getImya() + " " + human.getFamilie() + " " + human.getOtchestvo() + " " + human.getPol() + " " + human.getRost() + " - Рост");
        }
        jList1.setModel(list1); //выводит в лист
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
        String text = "Средний рост девочек: " + GirlRost / girlCount + "";
        //write(fileName, text);
        SaveFile(text, protect, fileName);

    }

    public static String read(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        exists(fileName);

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    System.out.println(s);
                    //sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }

    public static void write(String fileName, String text) throws IOException {

        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        out.print(text);
        out.close();
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    private static void SaveFile(String text, int protect, String fileName) throws IOException {

        if (protect == 1) {
            write(fileName, text);
        } else {
            System.out.println("ss");
        }

    }

    public void PR3Zad59() {
        String input = TextVvod.getText();
        String output = rmvSpaces(input);
        outputText.setText(output);

    }

    private String rmvSpaces(String input) {
        return input.replaceAll("\\s+", "");
    }

    public void PR3Zad34() {
        String input = Vvodrandom.getText(); //получаем введенную строку
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

    public void PR3Zad9() {
        String text = VvodTexta.getText(); //получение вводимого текста в строку
        if (VvodTexta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Строка не должна быть пуста");
            //   lblresullt.setVisible(false);
System.out.println("");
        } else {
            String[] words = text.split("\\s+"); //Разбиение текста на отдельные слова с помощью \\s+
            String lengths = "";
            for (String word : words) {
                lengths = lengths + " " + word + " - " + word.length();
            }
            lblresullt.setText(lengths); //вывод результата
        }
    }

    public void PR21() {
        tm = (DefaultTableModel) Table2.getModel();
        int row = Integer.parseInt(TEXTStrok1.getText());
        int col = Integer.parseInt(TEXTStolb1.getText());
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
        if (VvodMatrix.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Строка не должна быть пуста");
        } else {
            int n = Integer.parseInt(VvodMatrix.getText());

            tm = (DefaultTableModel) Table1.getModel();
            int row = (n);
            int col = (n);
            tm.setColumnCount(col);

            int[][] matrix = new int[n][n];
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

//        System.out.println("matrix:");
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
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
//        System.out.print(" [");
            for (int j = 0; j < n; j++) {
                lblRezu1.setText(lblRezu1.getText() + matrix[maxIndex][j] + " ");

            }
//        System.out.println("]");
            int sum1 = 0;
            for (int i : matrix[maxIndex]) {
                sum1 += i;

            }
            lblMatSum.setText(+sum1 + " "); //вывод суммы матрицы
//        System.out.println("matrix sum: " + sum1);
        }
    }

//тест задача
    public void table() {
        char ch = 0;
        String txt = "";
        for (int i = 0; i < 6; i++) {
            txt += ch;
            ch++;
        }
        jTextArea1.setText(txt);
    }
    //тест задача

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
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (Math.random() * 9 + 1);
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

        File file = new File(fileName);
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        btnStart3 = new javax.swing.JButton();
        lblMasElements2TEXT = new javax.swing.JLabel();
        lblMasElem2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        lblTRWmSI = new javax.swing.JLabel();
        lblRezu = new javax.swing.JLabel();
        lblRezu1 = new javax.swing.JLabel();
        lblMatrixSum = new javax.swing.JLabel();
        lblMatSum = new javax.swing.JLabel();
        VvodMatrix = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Panel34raz2 = new javax.swing.JPanel();
        TEXTZAD3RAZ2lbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        TEXTStrok1 = new javax.swing.JTextField();
        TEXTStolb1 = new javax.swing.JTextField();
        lblKolvoStrok = new javax.swing.JLabel();
        lblKolVoStolbsov = new javax.swing.JLabel();
        btnPR232 = new javax.swing.JButton();
        lblMaxElementsStolbecTXT = new javax.swing.JLabel();
        lblMaxInMinElemTXT = new javax.swing.JLabel();
        lblMaxElemStolbec = new javax.swing.JLabel();
        lblMaxMin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lblSredn = new javax.swing.JLabel();
        AdresTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FileNametxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSoxr = new javax.swing.JButton();
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
                        .addGap(0, 323, Short.MAX_VALUE)))
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
                        .addGap(0, 402, Short.MAX_VALUE)))
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

        jLabel1.setText("<html>В одномерном массиве хранится информация о коммунальных платежах каждой из семей 20-квартирного дома за месяц.<p> Определить: а) общую сумму платежей; б) номера квартир, которые не оплатили коммунальные услуги; <p> в) номера квартир, платежи которых превысили заданное значение.</html>");

        btnStart3.setText("Start");
        btnStart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart3ActionPerformed(evt);
            }
        });

        lblMasElements2TEXT.setText("Elements:");

        lblMasElem2.setText("0");

        jLabel2.setText("Номера квартир которые привысили платёж");

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
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel59Layout.createSequentialGroup()
                                .addComponent(lblMasElements2TEXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMasElem2))
                            .addGroup(panel59Layout.createSequentialGroup()
                                .addComponent(jLabel2)
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
                        .addGap(0, 324, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel59Layout.setVerticalGroup(
            panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMasElements2TEXT)
                    .addComponent(lblMasElem2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKvar)
                    .addComponent(jLabel2))
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
        jScrollPane2.setViewportView(Table1);

        lblTRWmSI.setText("The row with max sum is:");

        lblRezu.setText("0");

        lblMatrixSum.setText("Matrix sum: ");

        lblMatSum.setText("0");

        VvodMatrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VvodMatrixActionPerformed(evt);
            }
        });

        jLabel3.setText("Введите матрицу");

        javax.swing.GroupLayout Panel9raz2Layout = new javax.swing.GroupLayout(Panel9raz2);
        Panel9raz2.setLayout(Panel9raz2Layout);
        Panel9raz2Layout.setHorizontalGroup(
            Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel9raz2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                        .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel9raz2Layout.createSequentialGroup()
                                .addComponent(lblTRWmSI, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRezu)
                                .addGap(18, 18, 18)
                                .addComponent(lblRezu1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel9raz2Layout.createSequentialGroup()
                                .addComponent(lblMatrixSum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMatSum)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                        .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btStart9r2)
                            .addComponent(lblTEXTZADACHA9R2)
                            .addGroup(Panel9raz2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(VvodMatrix, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(162, Short.MAX_VALUE))))
        );
        Panel9raz2Layout.setVerticalGroup(
            Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel9raz2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTEXTZADACHA9R2)
                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel9raz2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VvodMatrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(52, 52, 52)
                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRezu1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTRWmSI)
                        .addComponent(lblRezu)))
                .addGap(18, 18, 18)
                .addGroup(Panel9raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatrixSum)
                    .addComponent(lblMatSum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(btStart9r2)
                .addGap(33, 33, 33))
        );

        jTabbedPane2.addTab("Задача 9", Panel9raz2);

        TEXTZAD3RAZ2lbl.setText("<html>Вывести на экран матрицу 10x8, элементами которой являются целые случайные числа из интервала [19,49]. <p> Определить минимальный элемент в каждом столбце и выбрать из них максимальный.");

        Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Столбец 1", "Столбец 2", "Столбец 3", "Столбец 4", "Столбец 5", "Столбец 6", "Столбец 7", "Столбец 8", "Столбец 9", "Столбец 10"
            }
        ));
        jScrollPane3.setViewportView(Table2);

        TEXTStrok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEXTStrok1ActionPerformed(evt);
            }
        });

        TEXTStolb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEXTStolb1ActionPerformed(evt);
            }
        });

        lblKolvoStrok.setText("Кол-во строк:");

        lblKolVoStolbsov.setText("Кол-во столбцов:");

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
                .addGap(18, 18, 18)
                .addGroup(Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel34raz2Layout.createSequentialGroup()
                        .addGap(0, 180, Short.MAX_VALUE)
                        .addComponent(btnPR232)
                        .addGap(35, 35, 35))
                    .addGroup(Panel34raz2Layout.createSequentialGroup()
                        .addGroup(Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKolvoStrok)
                            .addComponent(lblKolVoStolbsov))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TEXTStrok1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TEXTStolb1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel34raz2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TEXTZAD3RAZ2lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel34raz2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKolvoStrok)
                            .addComponent(TEXTStrok1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addGroup(Panel34raz2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKolVoStolbsov)
                            .addComponent(TEXTStolb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        jButton1.setText("Старт");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Пример", jPanel1);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PalelZadacha9Layout.createSequentialGroup()
                .addGap(21, 632, Short.MAX_VALUE)
                .addComponent(btnStart6)
                .addGap(189, 189, 189))
            .addGroup(PalelZadacha9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PalelZadacha9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRaz3Zadanie9, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PalelZadacha9Layout.createSequentialGroup()
                        .addComponent(lblVvodTexta)
                        .addGap(18, 18, 18)
                        .addComponent(VvodTexta, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblresullt, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PalelZadacha9Layout.setVerticalGroup(
            PalelZadacha9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PalelZadacha9Layout.createSequentialGroup()
                .addGap(0, 240, Short.MAX_VALUE)
                .addComponent(btnStart6)
                .addGap(127, 127, 127))
            .addGroup(PalelZadacha9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRaz3Zadanie9)
                .addGap(18, 18, 18)
                .addGroup(PalelZadacha9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVvodTexta)
                    .addComponent(VvodTexta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblresullt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 113, Short.MAX_VALUE))
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
            .addGap(0, 473, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Задача 9", jPanel4);

        lblZadacha34Raz4text.setText("Создать файл, содержащий данные: ФИО ученика; пол; рост. Просмотреть данные из файла. Определить средний рост девочек.");

        btnStartRaz4Zad34.setText("Start");
        btnStartRaz4Zad34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartRaz4Zad34ActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(jList1);

        AdresTxt.setText("C:\\");
            AdresTxt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AdresTxtActionPerformed(evt);
                }
            });

            jLabel4.setText("Введите адрес для сохранения файла:");

            FileNametxt.setText("FileName");
            FileNametxt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    FileNametxtActionPerformed(evt);
                }
            });

            jLabel5.setText("Введите имя файла:");

            btnSoxr.setText("Сохранить файл");
            btnSoxr.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSoxrActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblZadacha34Raz4text)
                    .addContainerGap(140, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(AdresTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78)
                            .addComponent(FileNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblSredn)
                            .addGap(27, 27, 27)
                            .addComponent(btnSoxr)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStartRaz4Zad34)
                            .addGap(117, 117, 117))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblZadacha34Raz4text)
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSredn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStartRaz4Zad34)
                            .addComponent(AdresTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FileNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSoxr)))
                    .addGap(132, 132, 132))
            );

            jTabbedPane4.addTab("Задача 34", jPanel5);

            javax.swing.GroupLayout razdel4Layout = new javax.swing.GroupLayout(razdel4);
            razdel4.setLayout(razdel4Layout);
            razdel4Layout.setHorizontalGroup(
                razdel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(razdel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(161, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        table();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPR232ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPR232ActionPerformed
        tm.setRowCount(0);
        PR21();
    }//GEN-LAST:event_btnPR232ActionPerformed

    private void TEXTStolb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEXTStolb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEXTStolb1ActionPerformed

    private void TEXTStrok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEXTStrok1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEXTStrok1ActionPerformed

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
        int protect = 0;
        try {
            PR4Zad34(protect);
        } catch (IOException ex) {
            Logger.getLogger(Tasks1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStartRaz4Zad34ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Разработчик: Кузнецов Антон");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void VvodMatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VvodMatrixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VvodMatrixActionPerformed

    private void FileNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileNametxtActionPerformed

    private void btnSoxrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoxrActionPerformed
        int protect = 1;
        try {
            PR4Zad34(protect);
        } catch (IOException ex) {
            Logger.getLogger(Tasks1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSoxrActionPerformed

    private void AdresTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdresTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdresTxtActionPerformed

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
    private javax.swing.JTextField AdresTxt;
    private javax.swing.JTextField FileNametxt;
    private javax.swing.JPanel PalelZadacha34;
    private javax.swing.JPanel PalelZadacha59;
    private javax.swing.JPanel PalelZadacha9;
    private javax.swing.JPanel Panel34raz2;
    private javax.swing.JPanel Panel9raz2;
    private javax.swing.JTextField TEXTStolb1;
    private javax.swing.JTextField TEXTStrok1;
    private javax.swing.JLabel TEXTZAD3RAZ2lbl;
    private javax.swing.JTable Table1;
    private javax.swing.JTable Table2;
    private javax.swing.JTextField TextVvod;
    private javax.swing.JTextField VvodMatrix;
    private javax.swing.JTextField VvodTexta;
    private javax.swing.JTextField Vvodrandom;
    private javax.swing.JButton btStart9r2;
    private javax.swing.JButton btnPR232;
    private javax.swing.JButton btnSoxr;
    private javax.swing.JButton btnStart1;
    private javax.swing.JButton btnStart2;
    private javax.swing.JButton btnStart3;
    private javax.swing.JButton btnStart6;
    private javax.swing.JButton btnStart8;
    private javax.swing.JButton btnStartRaz3Zad34;
    private javax.swing.JButton btnStartRaz4Zad34;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblInfoRAZ3ZAD34;
    private javax.swing.JLabel lblIsxMas;
    private javax.swing.JLabel lblIsxMasTEXT;
    private javax.swing.JLabel lblIzmMas;
    private javax.swing.JLabel lblIzmTEXT;
    private javax.swing.JLabel lblKolVoStolbsov;
    private javax.swing.JLabel lblKolvoStrok;
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
    private javax.swing.JLabel lblNotPaid;
    private javax.swing.JLabel lblNotPaidTEXT;
    private javax.swing.JLabel lblObshSum;
    private javax.swing.JLabel lblObshSumTEXT;
    private javax.swing.JLabel lblOtsut;
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
    private javax.swing.JLabel lblVvodTexta;
    private javax.swing.JLabel lblZadacha34Raz4text;
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
    private javax.swing.JTabbedPane task9;
    // End of variables declaration//GEN-END:variables

}
