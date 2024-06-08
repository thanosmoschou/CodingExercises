package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/*
 * The Application class of the package javafx.application is the entry point of the application in JavaFX. 
 * To create a JavaFX application, you need to inherit this class and implement its abstract method start(). 
 * In this method, you need to write the entire code for the JavaFX graphics
   In the main method, you have to launch the application using the launch() method. 
   This method internally calls the start() method of the Application class.
 */

public class Main extends Application 
{
	public static void main(String[] args) 
	{
		/*
		 * Since the launch() method is static, you need to call it from a static context (main generally). 
		 * Whenever a JavaFX application is launched, the following actions will be carried out (in the same order).
		   An instance of the application class is created.
		   Init() method is called.
		   The start() method is called.
           The launcher waits for the application to finish and calls the stop() method.
		 */
		
		launch(args);
		
		//Terminating the JavaFX Application
		//When the last window of the application is closed, the JavaFX application is terminated implicitly. 
		//You can turn this behavior off by passing the Boolean value “False” to the static 
		//method setImplicitExit() (should be called from a static context).
		//You can terminate a JavaFX application explicitly using the methods Platform.exit() or System.exit(int).
	}
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		
		//In general, a JavaFX application will have three major components namely Stage, Scene and Nodes 
		//A stage (a window) contains all the objects of a JavaFX application. 
		//It is represented by Stage class of the package javafx.stage. 
		//The primary stage is created by the platform itself. 
		//The created stage object is passed as an argument to the start() method of the Application class 
		
		//A scene represents the physical contents of a JavaFX application. 
		//It contains all the contents of a scene graph. 
		//The class Scene of the package javafx.scene represents the scene object. 
		//At an instance, the scene object is added to only one stage.
		//You can create a scene by instantiating the Scene Class. 
		//You can opt for the size of the scene by passing its dimensions (height and width) along 
		//with the root node to its constructor.
		
		/*
		 * A scene graph is a tree-like data structure (hierarchical) representing the contents of a scene. 
		 * In contrast, a node is a visual/graphical object of a scene graph.

		   A node may include
		   Geometrical (Graphical) objects (2D and 3D) such as − Circle, Rectangle, Polygon, etc.
           UI Controls such as − Button, Checkbox, Choice Box, Text Area, etc.
           Containers (Layout Panes) such as Border Pane, Grid Pane, Flow Pane, etc.
           Media elements such as Audio, Video and Image Objects.

           The Node Class of the package javafx.scene represents a node in JavaFX, 
           this class is the super class of all the nodes.
		   As discussed earlier a node is of three types:

           Root Node − The first Scene Graph is known as the Root node.
           
           Branch Node/Parent Node − The node with child nodes are known as branch/parent nodes. 
           	The abstract class named Parent of the package javafx.scene is the base class of all the parent nodes, 
           	and those parent nodes will be of the following types −
           	
           	Group − A group node is a collective node that contains a list of children nodes. 
           	Whenever the group node is rendered, all its child nodes are rendered in order. 
           	Any transformation, effect state applied on the group will be applied to all the child nodes.

           	Region − It is the base class of all the JavaFX Node based UI Controls, such as Chart, Pane and Control.

           	WebView − This node manages the web engine and displays its contents.

           Leaf Node − The node without child nodes is known as the leaf node. For example, Rectangle, Ellipse, Box, ImageView, MediaView are examples of leaf nodes.

           It is mandatory to pass the root node to the scene graph. If the Group is passed as root, all the nodes will be clipped to the scene and any alteration in the size of the scene will not affect the layout of the scene.
		 */
		
		/*
		 * As per your application, you need to prepare a scene graph with required nodes. 
		 * Since the root node is the first node, you need to create a root node. 
		 * As a root node, you can choose from the Group, Region or WebView.
		 * 
		 * Group
		 * The getChildren() method of the Group class gives you an object of the ObservableList 
		 * class which holds the nodes. We can retrieve this object and add nodes to it with add method.
		 * 
		 * Region − It is the Base class of all the JavaFX Node-based UI Controls, such as 
		 
		   Chart − This class is the base class of all the charts and it belongs to the package javafx.scene.chart.
           This class has two sub classes, which are − PieChart and XYChart. 
           These two in turn have subclasses such as AreaChart, BarChart, BubbleChart, etc. 
           used to draw different types of XY-Plane Charts in JavaFX.
           You can use these classes to embed charts in your application.

           Pane − A Pane is the base class of all the layout panes such as AnchorPane, 
           BorderPane, DialogPane, etc. This class belong to a package that is called as − javafx.scene.layout.
           You can use these classes to insert predefined layouts in your application.

           Control − It is the base class of the User Interface controls such as Accordion, 
           ButtonBar, ChoiceBox, ComboBoxBase, HTMLEditor, etc. This class belongs to the package javafx.scene.control.
           You can use these classes to insert various UI elements in your application.
		 */
		
		try 
		{
			//I have the stage as a parameter to this method

			//create a root node for my scene graph
			//all parent nodes inherit from Parent class
			//I can select a root node from Group, Region or Webview
			//The following classes inherit from Region so I can have them as root nodes:
			//Chart, Pane, Control
			//The following classes inherit from Pane so I can have them as root nodes:
			//AnchorPane, BorderPane, DialogPane
			//The following classes inherit from Control so I can have them as root nodes:
			//Accordion, ButtonBar, ChoiceBox, ComboBoxBase, HTMLEditor etc.
			
			Group root = new Group();
			
			//or if you have an fxml file
			//Parent root = FXMLLoader.load(this.getClass().getResource("path/to/fxml"));
			
			//create the scene
			Scene scene = new Scene(root, 500, 500); 
			
			//add some color to the scene
			scene.setFill(Color.AQUA);
			
			//Create a line
			Line line = new Line();
			//specify the starting point and the ending point of the line (2 points define a line)
			line.setStartX(20);
			line.setStartY(20);
			line.setEndX(40);
			line.setEndY(100);
			
			//put the line to the scene by adding it to the scene graph
			root.getChildren().add(line);
			
			//Display text
			Text text = new Text("Hello"); //or you can set the text with setText method later in the app
			text.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
			text.setX(150);
			text.setY(150);
			text.setFill(Color.BLACK);
			text.setStrokeWidth(2);
			text.setStroke(Color.RED); //set the color of a boundary
			
			root.getChildren().add(text);
			
			//create a circle
			Circle circle = new Circle();
			//set the center point of a circle
			circle.setCenterX(250);
			circle.setCenterY(250);
			
			circle.setRadius(30);
			circle.setFill(Color.HOTPINK);
			
			root.getChildren().add(circle);
			
			//create a rectangle
			Rectangle rect = new Rectangle();
			//set width and height
			rect.setWidth(30);
			rect.setHeight(40);
			
			rect.setX(180);
			rect.setY(20);
			rect.setStrokeWidth(2);
			rect.setStroke(Color.RED);
			rect.setFill(Color.GREEN);
			
			root.getChildren().add(rect);
			
			//create a polygon
			Polygon poly = new Polygon();
			poly.getPoints().addAll(120.0, 150.0, 
									140.0, 160.0,
									170.0, 200.0);
			
			poly.setFill(Color.ORANGE);
			
			root.getChildren().add(poly);
			
			Sphere sph = new Sphere();
			sph.setRadius(40.0);
			sph.setTranslateX(100.0);
			sph.setTranslateY(290.0);
			sph.setCullFace(CullFace.BACK); //cull face is to remove the part that is not shown in the view area
			 
			PhongMaterial m = new PhongMaterial();
			m.setDiffuseColor(Color.RED);
			
			sph.setMaterial(m);
			
			root.getChildren().add(sph);
			
			//create an image
			Image image = new Image("/bird.jpg");
			
			//create an image view which is a place holder for images
			ImageView imageview = new ImageView(image);
			imageview.setX(300);
			imageview.setY(350);
			imageview.setFitWidth(200);
			imageview.setFitHeight(200);
			
			root.getChildren().add(imageview);
			
			//prepare the stage
			primaryStage.setTitle("Learning JavaFX");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
