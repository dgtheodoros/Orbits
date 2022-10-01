

import java.beans.EventHandler;
import java.util.Observable;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.application.Application;  
import javafx.geometry.Point3D;
import javafx.scene.Group;  
import javafx.scene.PerspectiveCamera;  
import javafx.scene.Scene;  
import javafx.scene.paint.Color;  
import javafx.scene.shape.CullFace;  
import javafx.scene.shape.Sphere;  
import javafx.stage.Stage;  
import javafx.scene.transform.Rotate; 
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.EventType;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.effect.Glow;  
import javafx.scene.input.MouseEvent;



public class EarthMoon extends Application{
    
    public void start(Stage primaryStage) throws Exception {
    
        // TODO Auto-generated method stub  
    //creating the sphere   Earth
    Sphere earth = new Sphere();  
  
    //setting the properties for the sphere object  
    earth.setRadius(30);  
    earth.setTranslateX(200);  
    earth.setTranslateY(150);  
    earth.setDrawMode(DrawMode.FILL);//setCullFace(CullFace.BACK);  
    //Preparing the phong material of type bump map  
      PhongMaterial material1 = new PhongMaterial();  
      Image img1 = new Image("images/earth_noClouds.0330.jpg");
      material1.setDiffuseMap(img1);  //   setBumpMap(img1);
      material1.setSpecularPower(10.0f);
      material1.setSpecularMap(img1);
      //Setting the bump map material to Cylinder1 
      earth.setMaterial(material1); 
      
      Tooltip tooltip = new Tooltip();
      earth.hoverProperty().addListener( (observable, oldValue, newValue) -> {
          
           tooltip.setText("This is Earth");
           tooltip.setAutoHide(true);
           tooltip.setAnchorX(200);
           tooltip.setAnchorY(200);
           
            if (newValue) {
                Tooltip.install(earth, tooltip);
            } else {
                Tooltip.uninstall(earth, tooltip);
            }
    
    });
      
      
    
      /* earth.setOnMouseEntered(new EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent t) {
         tooltip.setText("This is Earth");
           tooltip.setAutoHide(true);
           tooltip.setAnchorX(200);
           tooltip.setAnchorY(200);
        
        Tooltip.install(earth, tooltip);
    }
    });*/

      
      
      
      
    /*  earth.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler <MouseEvent>() {
          
          public void handle(MouseEvent e) {
            button1.setEffect(shadow);
          }
        });
    
     */
      
      
      
      
    //setting camera   
    PerspectiveCamera camera = new PerspectiveCamera();  
    camera.setTranslateX(0);  
    camera.setTranslateY(0);  
    camera.setTranslateZ(0);  
    
   
    //Instantiating RotateTransition class   
        RotateTransition rotate = new RotateTransition();  
          
        //Setting Axis of rotation   
        rotate.setAxis(Rotate.Y_AXIS);  
          
        // setting the angle of rotation   
        rotate.setByAngle(360);  
          
        //setting cycle count of the rotation   
        rotate.setCycleCount(1);  
          
        //Setting duration of the transition   
        rotate.setDuration(Duration.millis(4000));  
          
       //Setting the cycle count for the transition 
      rotate.setCycleCount(Timeline.INDEFINITE); 
      rotate.setInterpolator(Interpolator.LINEAR); 
        
        //the transition will be auto reversed by setting this to true   
        rotate.setAutoReverse(false);  
              
        //setting Rectangle as the node onto which the   
// transition will be applied  
        rotate.setNode(earth);  
          
        //playing the transition   
        rotate.play(); 
        
       //setting group for earth  
    Group earth_3d = new Group();  
    earth_3d.getChildren().addAll(earth); 
    
    //creating the sphere   Moon
    Sphere moon = new Sphere();  
  
    //setting the properties for the sphere object  
    moon.setRadius(10);  
    moon.setTranslateX(100);  
    moon.setTranslateY(150);  
    moon.setDrawMode(DrawMode.FILL);//setCullFace(CullFace.BACK);  
    //Preparing the phong material of type bump map  
      PhongMaterial material2 = new PhongMaterial();  
      Image img2 = new Image("images/moon-surface-flat-map-3d-rendering-R4MPR5.jpg");
      material2.setDiffuseMap(img2);  //   setBumpMap(img1);
      
      //Setting the bump map material to Cylinder1 
      moon.setMaterial(material2); 
      
    //setting camera   
   /* PerspectiveCamera camera = new PerspectiveCamera();  
    camera.setTranslateX(0);  
    camera.setTranslateY(0);  
    camera.setTranslateZ(0);  
    */
   
    //Instantiating RotateTransition class   
        RotateTransition moonrotate = new RotateTransition();  
          
        //Setting Axis of rotation   
        moonrotate.setAxis(Rotate.Y_AXIS);  
          
        // setting the angle of rotation   
        moonrotate.setByAngle(360);  
          
        //setting cycle count of the rotation   
        moonrotate.setCycleCount(2);  
          
        //Setting duration of the transition   
        moonrotate.setDuration(Duration.millis(2000));  
          
       //Setting the cycle count for the transition 
      moonrotate.setCycleCount(Timeline.INDEFINITE); 
      moonrotate.setInterpolator(Interpolator.LINEAR); 
        
        //the transition will be auto reversed by setting this to true   
        moonrotate.setAutoReverse(false);  
              
        //setting Rectangle as the node onto which the   
// transition will be applied  
        moonrotate.setNode(moon);  
          
        //playing the transition   
        moonrotate.play(); 
        
       //setting group for moon  
    Group moon_3d = new Group();  
    moon_3d.getChildren().addAll(moon);
    
    // Create the Path of moon
    
      //Drawing an ellipse 
      Ellipse moonpath = new Ellipse(); 
         
      //Setting the properties of the ellipse 
      moonpath.setCenterX(200.0f); 
      moonpath.setCenterY(150.0f); 
      moonpath.setRadiusX(70.0f); 
      moonpath.setRadiusY(50.0f); 
        
      moonpath.setFill(null);
      moonpath.setStroke(Color.RED);
      
      
       // Set up a Path Transition for the moon
        PathTransition moontrans = new PathTransition(Duration.seconds(10),moonpath,moon_3d);
        moontrans.setInterpolator(Interpolator.LINEAR);
        moontrans.setOrientation(PathTransition.OrientationType.NONE);
        // Let the animation run forever
        moontrans.setCycleCount(Timeline.INDEFINITE); //trans.setCycleCount(FadeTransition.INDEFINITE);
        // Reverse direction on alternating cycles
        moontrans.setAutoReverse(false);
        // Play the Animation
        moontrans.play();
        
        Group sp_3d = new Group();  
        sp_3d.getChildren().addAll(earth_3d);
        sp_3d.getChildren().addAll(moonpath);
        sp_3d.getChildren().addAll(moon_3d);
        
        // Create the Path of earth
        
         //Drawing an ellipse 
      Ellipse path = new Ellipse(); 
         
      //Setting the properties of the ellipse 
      path.setCenterX(600.0f); 
      path.setCenterY(400.0f); 
      path.setRadiusX(300.0f); 
      path.setRadiusY(200.0f); 
        
        path.setFill(null);
        path.setStroke(Color.RED);
       
     
      
      // Set up a Path Transition for the Planet
        PathTransition trans = new PathTransition(Duration.seconds(30),path,sp_3d);
        trans.setInterpolator(Interpolator.LINEAR);
        trans.setOrientation(PathTransition.OrientationType.NONE);
        // Let the animation run forever
        trans.setCycleCount(Timeline.INDEFINITE); //trans.setCycleCount(FadeTransition.INDEFINITE);
        // Reverse direction on alternating cycles
        trans.setAutoReverse(false);
        // Play the Animation
        trans.play();
        
        //creating the sphere   Sun
    Sphere sun = new Sphere();  
  
    //setting the properties for the sphere object  
    sun.setRadius(80);  
    sun.setTranslateX(600.0f);  
    sun.setTranslateY(400.0f);  
    sun.setDrawMode(DrawMode.FILL);//setCullFace(CullFace.BACK);  
    //Preparing the phong material of type bump map  
      PhongMaterial material3 = new PhongMaterial();  
      Image img3 = new Image("images/Sun_flat.jpg");
     // ImageView imgview1 = new ImageView(img3); 
     //  Glow glow = new Glow();   
     //  glow.setLevel(100);  
     //  sun.setEffect(glow); 
     material3.setDiffuseMap(img3);  //   setBumpMap(img1);
      //material3.setSelfIlluminationMap(img3);
      material3.setSpecularMap(img3);
      material3.setSpecularPower(0.0f);
      //Setting the  map values material to Sun 
      sun.setMaterial(material3); 
        
    //Instantiating RotateTransition class   
        RotateTransition sunrotate = new RotateTransition();  
          
        //Setting Axis of rotation   
        sunrotate.setAxis(Rotate.Y_AXIS);  
          
        // setting the angle of rotation   
        sunrotate.setByAngle(360);  
          
        //setting cycle count of the rotation   
        sunrotate.setCycleCount(1);  
          
        //Setting duration of the transition   
        sunrotate.setDuration(Duration.millis(4000));  
          
       //Setting the cycle count for the transition 
      sunrotate.setCycleCount(Timeline.INDEFINITE); 
      sunrotate.setInterpolator(Interpolator.LINEAR); 
        
        //the transition will be auto reversed by setting this to true   
        sunrotate.setAutoReverse(false);  
              
        //setting Rectangle as the node onto which the   
// transition will be applied  
        sunrotate.setNode(sun);  
          
        //playing the transition   
        sunrotate.play();   
        
        
        // Pulse beating effect in the Sun
        
         ScaleTransition scale = new ScaleTransition(Duration.millis(1000));  
         scale.setByX(0.05f);  
         scale.setByY(0.08f);
         scale.setByZ(0.1f);
         scale.setCycleCount(1);  
         scale.setCycleCount(Timeline.INDEFINITE);
         scale.setAutoReverse(true);  
         
        //Instantiating Parallel Transition class by passing the list of transitions into its constructor  
         ParallelTransition seqT = new ParallelTransition (sun,sunrotate,scale);  
           
         //playing the transition   
         seqT.play();  
      
         Path3D p1 = new Path3D();
         Group p11 = p1.root;
         
        Pane canvas = new Pane();
        
        //canvas.setStyle("-fx-background-color: black;");
        canvas.setPrefSize(1200,800);
       Image img4 = new Image("images/Pleiades_single_2.png");
        ImageView iv = new ImageView();
        iv.setImage(img4);
        HBox box = new HBox();
        box.getChildren().add(iv);
        box.setVisible(true);
        canvas.getChildren().add(box);
        canvas.getChildren().add(sun);
        canvas.getChildren().add(path);
        canvas.getChildren().add(sp_3d);
        //canvas.getChildren().add(p11);
        canvas.getClass().cast(p1.root);
        canvas.setCenterShape(true);
        //canvas.setLayoutX(200.0f);
        //canvas.setLayoutY(200.0f);
        
       
        
        Group root = new Group(canvas);
        
    Scene scene = new Scene(root,1200,900);  
    scene.setCamera(camera);  
    primaryStage.setScene(scene);  
    primaryStage.setTitle("Path 3D Example");  
    primaryStage.show();  
    
    
    
    
        
    }
    
    public static void main(String[] args) {  
        Path3D t = new Path3D();
    launch(args);  
    
    }
    
    /*
    public static void update(Observable o, Object arg) {
    Platform.runLater(new Runnable() {
        private Stage pstage;
       @Override
       public void run() {             
          Path3D t = new Path3D(); 
                   t.start(pstage);
                   
       }
    });
}*/
    
    
    
}
