package hellofx;

import javafx.application.Application;
        
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import java.sql.*;

public class covid19data extends Application 
{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/chk";     

    //  Database credentials
    static final String USER = "haider";                            
    static final String PASS = "Haider@786";                        
    
    static Connection conn = null;                                     
    static Statement stmt = null;
    
    String state="";
    int confirmed;
    int cured;
    int deaths;
    Label response,response1,response2,response3,response4;
    Scene scene,scene1,scene2,scene3,scene4,scenei1,scenei2,scenei3,scenei4;
    Stage myStage;
    public void start(Stage stage) throws FileNotFoundException
    {
        
            //////////////////////////////////////////////////////////////
            myStage =stage;
            myStage.setTitle("Covid 19");
            
            ///////////////////////////////////////////////////////////////////
            // --- All GridPanes ----////
            GridPane gp = giveroot();
            scene = new Scene(gp); // Creating a scene object   

            GridPane gp1 = giveroot();
            scene1 = new Scene(gp1); // Creating a scene object   
            
            GridPane gp2 = giveroot();
            scene2 = new Scene(gp2); // Creating a scene object   
            
            GridPane gp3 = giveroot();
            scene3 = new Scene(gp3); // Creating a scene object 
            
            GridPane gp4 = giveroot();
            scene4 = new Scene(gp4); // Creating a scene object
            
            GridPane gpi1 = giveroot();
            scenei1 = new Scene(gpi1); // Creating a scene object   
            
            GridPane gpi2 = giveroot();
            scenei2 = new Scene(gpi2); // Creating a scene object   
            
            GridPane gpi3 = giveroot();
            scenei3 = new Scene(gpi3); // Creating a scene object 
            
            GridPane gpi4 = giveroot();
            scenei4 = new Scene(gpi4); // Creating a scene object
            
//            gp1.setGridLinesVisible(true); 
        /////////////////////////////////////////////////////////////////////////
            
            MenuBar mb = createmb();
            MenuBar mb1 = createmb();
            MenuBar mb2 = createmb();
            MenuBar mb3 = createmb();
            MenuBar mb4 = createmb();
            MenuBar mb5 = createmb();
            MenuBar mb6 = createmb();
            MenuBar mb7 = createmb();
            MenuBar mb8 = createmb();
            
            ////////////////////////////////////////////
            response = createlabel(""); // Create a label that will report the selection.
            response1 = createlabel(""); // Create a label that will report the selection.
            response2 = createlabel(""); // Create a label that will report the selection.
            response3 = createlabel(""); // Create a label that will report the selection.
            response4 = createlabel(""); // Create a label that will report the selection.
            //////////////////////////////////////////////////////////////////////////////////
 
            // North States
            Button btn1 = createbutton("Jammu and Kashmir",stmt,conn);          
            Button btn2 = createbutton("Himachal Pradesh",stmt,conn);
            Button btn3 = createbutton("Haryana",stmt,conn);
            Button btn4 = createbutton("Chandigarh",stmt,conn);
            Button btn5 = createbutton("Delhi",stmt,conn);
            Button btn6 = createbutton("Uttarakhand",stmt,conn);
            Button btn7 = createbutton("Uttar Pradesh",stmt,conn);
            Button btn8 = createbutton("Punjab",stmt,conn);
            Button btn9 = createbutton("Madhya Pradesh",stmt,conn);
            Button btn10 = createbutton("Ladakh",stmt,conn);
            
            //west
            Button btn11 = createbutton("Maharashtra",stmt,conn);
            Button btn12 = createbutton("Goa",stmt,conn);
            Button btn13 = createbutton("Gujarat",stmt,conn);
            Button btn14 = createbutton("Rajasthan",stmt,conn);
            
            //east
            Button btn15 = createbutton("West Bengal",stmt,conn);
            Button btn16 = createbutton("Bihar",stmt,conn);
            Button btn17 = createbutton("Jharkhand",stmt,conn);
            Button btn18 = createbutton("Odisha",stmt,conn);
            Button btn19 = createbutton("Arunachal Pradesh",stmt,conn);
            Button btn20 = createbutton("Assam",stmt,conn);
            Button btn21 = createbutton("Chhattisgarh",stmt,conn);
            Button btn22 = createbutton("Manipur",stmt,conn);
            Button btn23 = createbutton("Meghalaya",stmt,conn);
            Button btn24 = createbutton("Mizoram",stmt,conn);
            Button btn25 = createbutton("Tripura",stmt,conn);
            
            //south
            Button btn26 = createbutton("Andhra Pradesh",stmt,conn);
            Button btn27 = createbutton("Karnataka",stmt,conn);
            Button btn28 = createbutton("Kerala",stmt,conn);
            Button btn29 = createbutton("Puducherry",stmt,conn);
            Button btn30 = createbutton("Tamil Nadu",stmt,conn);
            Button btn31 = createbutton("Telengana",stmt,conn);
            Button btn32 = createbutton("Andaman and Nicobar Islands",stmt,conn);
   
            
            /////////////////////////////////////////////////////////////////////////////
            
            Image homei = new Image(new FileInputStream("/home/najaf/NetBeansProjects/HelloFX/src/hellofx/pic/covid19.jpg"));
            ImageView homeiv = new ImageView(homei);
            homeiv.setFitHeight(400);
            homeiv.setFitWidth(400);
            
            //--//
            
            Image graph1i = new Image(new FileInputStream("/home/najaf/NetBeansProjects/HelloFX/src/hellofx/pic/total_cases.png"));
            ImageView graph1iv = new ImageView(graph1i);
            graph1iv.setFitHeight(400);
            graph1iv.setFitWidth(400);
            
            //--//
            
            Image graph2i = new Image(new FileInputStream("/home/najaf/NetBeansProjects/HelloFX/src/hellofx/pic/active_cases.png"));
            ImageView graph2iv = new ImageView(graph2i);
            graph2iv.setFitHeight(400);
            graph2iv.setFitWidth(400);
            
            //--//
            
            Image graph3i = new Image(new FileInputStream("/home/najaf/NetBeansProjects/HelloFX/src/hellofx/pic/daily_new_cases.png"));
            ImageView graph3iv = new ImageView(graph3i);
            graph3iv.setFitHeight(400);
            graph3iv.setFitWidth(400);
            
            //--//
            
            Image graph4i = new Image(new FileInputStream("/home/najaf/NetBeansProjects/HelloFX/src/hellofx/pic/total_deaths.png"));
            ImageView graph4iv = new ImageView(graph4i);
            graph4iv.setFitHeight(400);
            graph4iv.setFitWidth(400);
            
            //--//
            
            ///////////////////////////////////////////////////////////////////////////////////////////////
            
            gp.add(mb,0,0,40,3);
            gp.add(homeiv, 0,5,40,35);
                 
            
            ///////////////////////////////////////////////////////////////////////////////////////////////////
            //gp1
            gp1.add(mb1,0,0,40,3);
            gp1.add(btn1,0,3,20,3);
            gp1.add(btn2,0,6,20,3);
            gp1.add(btn3,0,9,20,3);
            gp1.add(btn4,0,12,20,3);
            gp1.add(btn5,0,15,20,3);
            gp1.add(btn6,0,18,20,3);
            gp1.add(btn7,0,21,20,3);
            gp1.add(btn8,0,24,20,3);
            gp1.add(btn9,0,27,20,3);
            gp1.add(btn10,0,30,20,3);
            gp1.add(response1,0,34,40,7);
            ///////////////////////////////////////////////////////////////////////////////////////////////////////
           //gp2
            gp2.add(mb2,0,0,40,3);
            gp2.add(btn11,0,3,20,3);
            gp2.add(btn12,0,6,20,3);
            gp2.add(btn13,0,9,20,3);
            gp2.add(btn14,0,12,20,3);
            gp2.add(response2,0,34,40,7);
            /////////////////////////////////////////////////////////////////////////////////////////////////////// 
            //gp3
            gp3.add(mb3,0,0,40,3);
            gp3.add(btn15,0,3,20,3);
            gp3.add(btn16,0,6,20,3);
            gp3.add(btn17,0,9,20,3);
            gp3.add(btn18,0,12,20,3);
            gp3.add(btn19,0,15,20,3);
            gp3.add(btn20,0,18,20,3);
            gp3.add(btn21,0,21,20,3);
            gp3.add(btn22,0,24,20,3);
            gp3.add(btn23,0,27,20,3);
            gp3.add(btn24,0,30,20,3);
            gp3.add(btn25,0,30,20,3);
            gp3.add(response3,0,34,40,7);
            ///////////////////////////////////////////////////////////////////////////////////////////////////////
            //gp4
            gp4.add(mb4,0,0,40,3);
            gp4.add(btn26,0,3,20,3);
            gp4.add(btn27,0,6,20,3);
            gp4.add(btn28,0,9,20,3);
            gp4.add(btn29,0,12,20,3);
            gp4.add(btn30,0,15,20,3);
            gp4.add(btn31,0,18,20,3);
            gp4.add(btn32,0,18,20,3);
            gp4.add(response4,0,34,40,7);
            ///////////////////////////////////////////////////////////////////////////////////////////////////////
            
            gpi1.add(mb5,0,0,40,3);
            gpi1.add(graph1iv, 0,5,40,35);
            //////////////////////////////////////////////////////////////
            gpi2.add(mb6,0,0,40,3);
            gpi2.add(graph2iv, 0,5,40,35);
            //////////////////////////////////////////////////////////////
            gpi3.add(mb7,0,0,40,3);
            gpi3.add(graph3iv, 0,5,40,35);
            //////////////////////////////////////////////////////////////
            gpi4.add(mb8,0,0,40,3);
            gpi4.add(graph4iv, 0,5,40,35);
            //////////////////////////////////////////////////////////////
            scene.getStylesheets().add("style2.css");
            scene1.getStylesheets().add("style2.css");
            scene2.getStylesheets().add("style2.css");
            scene3.getStylesheets().add("style2.css");
            scene4.getStylesheets().add("style2.css");
            scenei1.getStylesheets().add("style2.css");
            scenei2.getStylesheets().add("style2.css");
            scenei3.getStylesheets().add("style2.css");
            scenei4.getStylesheets().add("style2.css");
            myStage.setScene(scene); // Adding scene to the stage
            myStage.show();
        
    }
    public GridPane giveroot()
    {
        GridPane rootNode = new GridPane();    //Creating a Grid Pane 
        rootNode.setMinSize(400, 450); //Setting size for the pane  // col,row
        rootNode.setPadding(new Insets(10, 10, 10, 10)); //Setting the padding   
            
        int numRows = 40;
        int numColumns = 40;
        for (int row = 0 ; row < numRows ; row++ )
        {
            RowConstraints rc = new RowConstraints(10);
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            rootNode.getRowConstraints().add(rc);
        }
        
        for (int col = 0 ; col < numColumns; col++ ) 
        {
            ColumnConstraints cc = new ColumnConstraints(10);
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            rootNode.getColumnConstraints().add(cc);
        }
        return rootNode;
    }
    public Label createlabel(String text)
    {
        Label l = new Label(text);
        l.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return l;
    }
    public Button createbutton(String text,Statement stmt,Connection conn)
    {
        Button btn = new Button(text);
        btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn.setOnAction((e) -> {
                                    state = btn.getText();
                                    chk();
                                    response.setText("State: "+state+"\n"+"confirmed: "+confirmed+"\n"+"cured: "+cured+"\n"+"deaths: "+deaths+"\n");
                                    response1.setText("State: "+state+"\n"+"confirmed: "+confirmed+"\n"+"cured: "+cured+"\n"+"deaths: "+deaths+"\n");
                                    response2.setText("State: "+state+"\n"+"confirmed: "+confirmed+"\n"+"cured: "+cured+"\n"+"deaths: "+deaths+"\n");
                                    response3.setText("State: "+state+"\n"+"confirmed: "+confirmed+"\n"+"cured: "+cured+"\n"+"deaths: "+deaths+"\n");
                                    response4.setText("State: "+state+"\n"+"confirmed: "+confirmed+"\n"+"cured: "+cured+"\n"+"deaths: "+deaths+"\n");
                               }
                              );
        return btn;
    }
    public MenuBar createmb()
    {
         MenuBar mb = new MenuBar();  // Create the menu bar.

            Menu home = new Menu("_Home");
            MenuItem home_page = new MenuItem("Home");
            home.getItems().add(home_page);
            mb.getMenus().add(home);  
            
            Menu state = new Menu("_Statewise");

            MenuItem north = new MenuItem("North");
            MenuItem east = new MenuItem("East");
            MenuItem west = new MenuItem("West");
            MenuItem south = new MenuItem("South");      
            state.getItems().addAll(north, east, west, south);
            
            // ,new SeparatorMenuItem()
            mb.getMenus().add(state);  

            Menu graph = new Menu("_Graph");
            
            MenuItem total_cases = new MenuItem("total_cases");
            MenuItem active_cases = new MenuItem("active_cases");
            MenuItem daily_new_cases = new MenuItem("daily_new_cases");
            MenuItem total_death = new MenuItem("total_death");  
            graph.getItems().addAll(total_cases,active_cases,daily_new_cases,total_death);
            mb.getMenus().add(graph);
            
            //////////////////////////////////////////////////////////////////////////////////////////
         
            EventHandler<ActionEvent> MEHandler =	new EventHandler<ActionEvent>() 
                                            {
                                                    public void handle(ActionEvent ae) 
                                                    {
                                                            String name = ((MenuItem)ae.getTarget()).getText();
//                                                            if(name=="")
                                                            if(name=="Home")
                                                                myStage.setScene(scene);
                                                            if(name=="North")
                                                                myStage.setScene(scene1);
                                                            if(name=="West")
                                                                myStage.setScene(scene2);
                                                            if(name=="East")
                                                                myStage.setScene(scene3);
                                                            if(name=="South")
                                                                myStage.setScene(scene4);
                                                            if(name=="total_cases")
                                                                myStage.setScene(scenei1);
                                                            if(name=="active_cases")
                                                                myStage.setScene(scenei2);
                                                            if(name=="daily_new_cases")
                                                                myStage.setScene(scenei3);
                                                            if(name=="total_death")
                                                                myStage.setScene(scenei4);
                                                    }
                                            };
            // Set action event handlers for the menu items.
            home_page.setOnAction(MEHandler);
            north.setOnAction(MEHandler);
            east.setOnAction(MEHandler);
            west.setOnAction(MEHandler);
            south.setOnAction(MEHandler);
            total_cases.setOnAction(MEHandler);
            active_cases.setOnAction(MEHandler);
            daily_new_cases.setOnAction(MEHandler);
            total_death.setOnAction(MEHandler);
            return mb;
    }
    public void chk()
   {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * from covid where state="+"'"+state+"'";
            int flag=0;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                confirmed  = rs.getInt("confirmed");
                cured = rs.getInt("cured");			
                deaths = rs.getInt("deaths");			
            }
            rs.close();
        }
        catch(SQLException se)  {  se.printStackTrace();  }
        catch(Exception e)  {   e.printStackTrace();  }
        finally
        {
                try
                {
                        if(stmt!=null)
                                conn.close();
                        if(conn!=null)
                                conn.close();
                }
                catch(SQLException se){   se.printStackTrace();   }// do nothing
        }
   }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
