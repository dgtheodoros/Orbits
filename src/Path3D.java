import javafx.animation.Interpolator;
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
import javafx.animation.Timeline;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;


public class Path3D {
    
    public Group root;
    
    
    
    
    //@Override  
public void init(Stage pstage)  {  
    // TODO Auto-generated method stub  
    //creating the sphere   
    Sphere s = new Sphere();  
  
    //setting the properties for the sphere object  
    s.setRadius(30);  
    s.setTranslateX(200);  
    s.setTranslateY(150);  
    s.setDrawMode(DrawMode.FILL);//setCullFace(CullFace.BACK);  
    //Preparing the phong material of type bump map  
      PhongMaterial material1 = new PhongMaterial();  
      Image img1 = new Image("images/earth_noClouds.0330.jpg");
        
      material1.setDiffuseMap(img1);  //   setBumpMap(img1);
      
      //Setting the bump map material to Cylinder1 
      s.setMaterial(material1); 
      
      
      
      
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
        rotate.setNode(s);  
          
        //playing the transition   
        rotate.play(); 
    
    
    //setting group for earth  
    Group sp_3d = new Group();  
    sp_3d.getChildren().addAll(s);  
    
    
    // Create the Path of earth
        //Circle path = new Circle(300, 300, 150);
         //Drawing an ellipse 
      Ellipse path = new Ellipse(); 
         
      //Setting the properties of the ellipse 
      path.setCenterX(600.0f); 
      path.setCenterY(400.0f); 
      path.setRadiusX(600.0f); 
      path.setRadiusY(400.0f); 
        
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
    
        
         root = new Group(path,sp_3d);
        
    Scene scene = new Scene(root,1200,900);  
    scene.setCamera(camera);  
    pstage.setScene(scene);  
    //pstage.setTitle("Path 3D Example");  
    pstage.show();  
}  



/*public static void main(String[] args) {  
    launch(args);  
} */ 

    
 public Group run(){
    
        return this.root;
    }   
    
}
