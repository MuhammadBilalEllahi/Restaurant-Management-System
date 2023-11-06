package System;

import System.JDBC.SingeltonJDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Order  {

    public static int Height = 900;
    public static int Width = 1500;

    public static List list = new ArrayList<>();

    public static TableView<TableData_class> table = new TableView<TableData_class>();
    public static ObservableList<TableData_class> observableList = FXCollections.observableList(list);
    public static TextField total_field = new TextField("");

    public static TextField cashAmountTextField = new TextField();
    public static TextField balanceAmountTextField = new TextField();


    public static Scene orderScene(){
        BorderPane root = new BorderPane();


        Button imageLeftButton = new Button("Image");
        VBox vboxLeftImage = new VBox(imageLeftButton);

        Button homeLeftButton = new Button("Home");
        Button menuLeftButton = new Button("Menu");
        Button historyLeftButton = new Button("History");
        Button promosLeftButton = new Button("Promos");
        Button settingsLeftButton = new Button("Settings");
        VBox vboxLeftOptions = new VBox(homeLeftButton,menuLeftButton,historyLeftButton,promosLeftButton,settingsLeftButton);

        Button logOutbutton = new Button("Log out");
        VBox vboxLeftLogOut = new VBox(logOutbutton);
        VBox vboxLeft = new VBox(vboxLeftImage, vboxLeftOptions,vboxLeftLogOut);
        vboxLeft.setBackground(Background.fill(Color.WHITE));



        Insets insetsForLeftBox = new Insets(20, 0, 50, 20);
        vboxLeftImage.setPadding(insetsForLeftBox);


        Insets insetsForHeadings = new Insets(20, 10, 10, 20);
        vboxLeftOptions.setPadding(insetsForHeadings);
        vboxLeftOptions.setSpacing(40);

        Insets insetsForLogOut = new Insets(200, 10, 10, 20);
        vboxLeftLogOut.setPadding(insetsForLogOut);







//These will come from MENU
        Button Breakfast_btn_in_pos = new Button("Breakfast");
        Button Salad_btn_in_pos = new Button("Salads");
        Button Cakes_btn_in_pos = new Button("Cakes");
        //Button Appetizer_btn_in_pos = new Button("Appetizers");
        Button Healthy_Menu_btn_in_pos = new Button("Healthy Menu");
        Button Pasta_btn_in_pos = new Button("Pasta");
        Button MainDish_btn_in_pos = new Button("Main Dish");
        Button Pizza_btn_in_pos = new Button("Pizza");
        Button Soup_btn_in_pos = new Button("Soups");
        Button ChildrenMenu_btn_in_pos = new Button("Children Menu");
        Button Drinks_btn_in_pos = new Button("Drinks");

        CategoryButton_Formatting  (Breakfast_btn_in_pos);
        CategoryButton_Formatting  (Salad_btn_in_pos);
        CategoryButton_Formatting  (Cakes_btn_in_pos);
        CategoryButton_Formatting  (Healthy_Menu_btn_in_pos);
        CategoryButton_Formatting  (Pasta_btn_in_pos);
        CategoryButton_Formatting  (MainDish_btn_in_pos);
        CategoryButton_Formatting  (Pizza_btn_in_pos);
        CategoryButton_Formatting  (Soup_btn_in_pos);
        CategoryButton_Formatting  (ChildrenMenu_btn_in_pos);
        CategoryButton_Formatting  (Drinks_btn_in_pos);


        Button search_btn = new Button("Search");
        TextField search_textField = new TextField();
        Text category_text = new Text("Chose Category");
        //Text category_text_ = new Text("Chose product");





        VBox CategoryView = new VBox();
        CategoryView.setPadding(new Insets(0, 0, 20, 0));




        HBox listInLines = new HBox(); //for menu items
        VBox ItemsView = new VBox(listInLines);
        ItemsView.setPadding(new Insets(10, 10, 10, 10));
        Text texT = new Text("Welcome");
        VBox WelcomeView = new VBox(texT);
        ItemsView.getChildren().add(WelcomeView);
        //VBox CategoryLabelView = new VBox();

        VBox MenuView = new VBox(CategoryView,ItemsView);

        Salad_btn_in_pos.setOnAction(actionEvent -> {
            ItemsView.getChildren().clear();

        });
        Breakfast_btn_in_pos.setOnAction(e -> {
            ItemsView.getChildren().clear();

            Menu(ItemsView,listInLines,
                    createButton("Egg"),
                    createButton("Toast"),
                    createButton("XYZ1"),
                    createButton("XYZ2"),
                    createButton("XYZ3"),
                    createButton("XYZ4"),
                    createButton("XYZ5"),
                    createButton("XYZ6"),
                    createButton("XYZ7")
            );


        });
        menuLeftButton.setOnAction(e->{
            ItemsView.getChildren().clear();


            menuLeftButton.setStyle(" -fx-background-radius: 9px; -fx-background-color: Brown; -fx-text-fill: white ");

            HBox CategoryText_Box = new HBox(category_text,search_btn);
            CategoryText_Box.setSpacing(600);
            CategoryText_Box.setAlignment(Pos.CENTER);
            //CategoryText_Box.setPadding(new Insets(0, 0, 0, 0));
            CategoryText_Box.setMinHeight(70);
            category_text.setFont(Font.font("Verdana", FontWeight.BOLD,15));


            HBox ItemListViewBox = new HBox(Breakfast_btn_in_pos,
                    Salad_btn_in_pos, Cakes_btn_in_pos, Healthy_Menu_btn_in_pos,
                    Pizza_btn_in_pos, Pasta_btn_in_pos, MainDish_btn_in_pos,
                    Soup_btn_in_pos,ChildrenMenu_btn_in_pos,Drinks_btn_in_pos
            );


            ItemListViewBox.setSpacing(15);
            ItemListViewBox.setMinHeight(50);
            ItemListViewBox.setAlignment(Pos.CENTER);
            CategoryView.getChildren().addAll(CategoryText_Box,ItemListViewBox);

        });
        root.setCenter(MenuView);


        {

            TableColumn<TableData_class, Integer> id = new TableColumn<TableData_class, Integer>("ID");
            id.setCellValueFactory(new PropertyValueFactory<TableData_class, Integer>("id"));

            TableColumn<TableData_class, String> item = new TableColumn<TableData_class, String>("Item");
            item.setCellValueFactory(new PropertyValueFactory<TableData_class, String>("name"));

            TableColumn<TableData_class,Integer> quantity = new TableColumn<TableData_class, Integer>("Quantity");
            quantity.setCellValueFactory(new PropertyValueFactory<TableData_class, Integer>("quantity"));

            TableColumn<TableData_class,Float> price = new TableColumn<TableData_class, Float>("Price");
            price.setCellValueFactory(new PropertyValueFactory<TableData_class, Float>("price"));


            TableColumn<TableData_class, String> Invoice = new TableColumn<TableData_class, String>("Invoice" );
            Invoice.setCellValueFactory(new PropertyValueFactory<TableData_class, String>("invoice"));
            // Invoice.setV

            //+ new TableData_class(1).getInvoice()
            Invoice.getColumns().addAll(id, item, quantity, price);

            table.getColumns().addAll(Invoice);
            table.refresh();
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            table.setBackground(Background.fill(Color.WHITESMOKE));
            table.setItems(observableList);

            table.setMinWidth(380);
        }


        //SingeltonJDBC.getInstance();




        Label TotalAmountlabel = new Label("Total");
        Label CashAmountlabel = new Label("Cash");
        Label BalanceAmountlabel = new Label("Balance");

        VBox Label_Vbox = new VBox(TotalAmountlabel,CashAmountlabel,BalanceAmountlabel);
        VBox TextField_Vbox = new VBox(total_field,cashAmountTextField,balanceAmountTextField);
        HBox Combined_Hbox = new HBox(Label_Vbox,TextField_Vbox);

        Button Discount_btn_in_pos = new Button("Disc");
        Discount_btn_in_pos.setMinWidth(50);

        Button Delete = new Button("Delete");
        Delete.setMinWidth(50);



        HBox EndHBox = new HBox(Delete,Discount_btn_in_pos);
        EndHBox.setAlignment(Pos.CENTER);
        EndHBox.setSpacing(120);

        VBox EndVBoxFull = new VBox(EndHBox);
        EndVBoxFull.setSpacing(15);

        Button Print = new Button("Print");
        Print.setMinWidth(220);
        VBox EndVBox = new VBox(Print);
        EndVBox.setAlignment(Pos.CENTER);
        EndVBox.setSpacing(10);

        Label Payment_Method_Label = new Label("Payment Method");
        Payment_Method_Label.setFont(Font.font("Arial",FontWeight.BOLD,18));
        Button Payment_Method_Button_Cash = new Button("Cash");
        Button Payment_Method_Button_Card = new Button("Card");
        Button Payment_Method_Button_Epay = new Button("E Wallet");
        PaymentButton_Formatting(Payment_Method_Button_Cash);
        PaymentButton_Formatting(Payment_Method_Button_Card);
        PaymentButton_Formatting(Payment_Method_Button_Epay);

        HBox PaymentMethod_HBox = new HBox(
                Payment_Method_Button_Cash,
                Payment_Method_Button_Card,
                Payment_Method_Button_Epay);
        PaymentMethod_HBox.setPadding(new Insets(30,0,0,20));
        PaymentMethod_HBox.setSpacing(20);

        VBox PaymentMethod_VBox = new VBox(Payment_Method_Label,PaymentMethod_HBox);


        VBox employee_bill_table_box = new VBox(table,Combined_Hbox,EndVBoxFull,PaymentMethod_VBox,EndVBox);
        employee_bill_table_box.setSpacing(40);




        employee_bill_table_box.setMinHeight(600);

        Combined_Hbox.setAlignment(Pos.BOTTOM_CENTER);
        Combined_Hbox.setMinHeight(100);

        Label_Vbox.setSpacing(20);
        TextField_Vbox.setSpacing(5);
        Combined_Hbox.setSpacing(120);


        total_field.setEditable(false);
        balanceAmountTextField.setEditable(false);
        cashAmountTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                // Remove non-numeric character at the end
                cashAmountTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }

            updateBalance(); // Update balance field
        });

        cashAmountTextField.setOnAction(cf -> {
            updateBalance(); // Update balance field
        });


        Discount_btn_in_pos.setOnAction(e->{
            double discount = Double.parseDouble(total_field.getText());
            //String.format("%.2f",discount);
            double s = discount - (discount * 0.2);
            total_field.setText(String.format("%.2f",s));
        });
        Print.setOnAction(e -> {
            //double checkTotal = Double.parseDouble(total_field.getText());
            if ( !(observableList.isEmpty())   ) {

                if (cashAmountTextField.getText().equals("0") && balanceAmountTextField.getText().equals("0")) {

                    cashAmountTextField.setBackground(Background.fill(Color.ORANGERED));
                }
                if (cashAmountTextField.getText().equals("") && balanceAmountTextField.getText().equals("")) {

                    cashAmountTextField.setBackground(Background.fill(Color.ORANGERED));
                } else {

                    double x = Double.parseDouble(cashAmountTextField.getText());
                    double y = Double.parseDouble(total_field.getText());

                    if (x >= y) {

                        if (x >= 0) {
                            balanceAmountTextField.setText(String.format("%.2f", x - y));
                            cashAmountTextField.setStyle("-fx-text-fill: BLACK");
                            //Print.setGraphic();
                            Print_Receipt.getPrint_Receipt();
                        }
                    } else {
                        balanceAmountTextField.setStyle("-fx-text-fill: RED");
                    }


                }
            }
        });
        Delete.setOnAction(e -> {


            for (TableData_class t : table.getSelectionModel().getSelectedItems()) {
                observableList.remove(t);
                Total_amount();
                updateBalance();
                /*if (t.getName().toLowerCase().contains("egg"))
                    Eggs_btn_in_pos_text.setText(String.valueOf(0));
                if (t.getName().toLowerCase().contains("french"))
                    French_toast_btn_in_pos_text.setText(String.valueOf(0));*/
            }

        });




        root.setRight(employee_bill_table_box);
        root.setLeft(vboxLeft);


        Scene scene = new Scene(root,Width,Height);
        responsiveness(root,scene);

        return scene;
    }

    public static void updateBalance() {

            double total_f = Double.parseDouble(total_field.getText());
            double total_c = Double.parseDouble(cashAmountTextField.getText());

            double total_amount = total_c - total_f;
            double balance = Math.max(total_amount, 0);
            balanceAmountTextField.setText(String.format("%.2f", balance));

    }


    public static  void update_data(String food_name,double price,int id ){

        TableData_class food_table = new TableData_class(food_name);


        if (observableList.contains(food_table))
        {
            TableData_class food_item = observableList.get(observableList.indexOf(food_table));
            food_item.setQuantity(food_item.getQuantity()+1);
            food_item.setPrice(price * food_item.getQuantity());

        }
        else
            observableList.add(new TableData_class(id, food_name, 1, price ));
//new SecureRandom().nextInt(Integer.MAX_VALUE%100)
        Total_amount();
    }
    public static void Total_amount(){
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        table.getItems().forEach(tableData_class -> {
            total.updateAndGet(v -> (double) (v + tableData_class.getPrice()));
        });
        total_field.setText(String.format("%.2f",total.get()));
        if (total_field != null){updateBalance();}


    }
    public static void responsiveness(BorderPane root, Scene scene) {
        root.prefHeightProperty().bind(scene.heightProperty());
        root.prefWidthProperty().bind(scene.widthProperty());
    }
    private static void CategoryButton_Formatting(Button button) {
        button.setMinHeight(80);
        button.setMinWidth(70);
        button.setWrapText(true);
        button.setStyle(" -fx-background-radius: 9px; -fx-background-color: WHITE; ");
    }
    private static void PaymentButton_Formatting(Button button) {
        button.setMinHeight(60);
        button.setMinWidth(60);
        button.setWrapText(true);
        button.setStyle(" -fx-background-radius: 9px; -fx-background-color: brown; ");

    }
    public  static Button createButton(String name){

        Button button = new Button();
        button.setText(name);

        button.setOnAction(e -> {


            if(observableList !=null)
            {
                update_data(button.getText(),4.20, new SecureRandom().nextInt(Integer.MAX_VALUE%100));
            }
            table.refresh();



        });

        return button;
}
    public static void Menu(VBox v, HBox h, Button... buttons) {

        int numFoodHBoxes = (int) Math.ceil(buttons.length / 4.0);
        HBox[] food_hBoxes = new HBox[numFoodHBoxes];

        for (int i = 0; i < numFoodHBoxes; i++) {
            int startIndex = i * 4;
            int endIndex = Math.min(startIndex + 4, buttons.length);

            HBox food_hBox = new HBox();
            food_hBox.setSpacing(20);
            food_hBox.setAlignment(Pos.CENTER);

            for (int j = startIndex; j < endIndex; j++) {
                Button button = buttons[j];
                food_hBox.getChildren().add(button);
            }

            food_hBoxes[i] = food_hBox;
        }


        VBox BreakFast_items12 = new VBox(food_hBoxes);
        //BreakFast_items12.setBackground(Background.fill(Color.rgb(235, 242, 250)));
        BreakFast_items12.setSpacing(50);
        BreakFast_items12.setMinHeight(40);



        for (Button button : buttons) {
            button.setMinWidth(150);
            button.setMinHeight(130);
        }

        VBox bottom_box2 = new VBox(BreakFast_items12);
        VBox join2 = new VBox(h, bottom_box2);



        v.getChildren().addAll(join2);
    }
}
