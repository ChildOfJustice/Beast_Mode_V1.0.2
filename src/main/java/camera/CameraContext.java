package camera;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.input.ChaseCamera;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.renderer.Camera;
import com.jme3.system.AppSettings;

public class CameraContext extends AbstractAppState {

    private final AppSettings settings;
    private final InputManager inputManager;
    /*
     http://javadoc.jmonkeyengine.org/com/jme3/renderer/Camera.html
     public class Camera
     extends java.lang.Object
     implements Savable, java.lang.Cloneable

     Ширина и высота устанавливаются в значения текущих параметров Application's settings.getWidth() и settings.getHeight().
     Перспектива Пирамиды видимости:
     Рамки угла обзора в 45Â° вдоль оси Y
     Соотношение сторон ширина делённая на высоту
     Плоскость обзора вблизи 1 wu
     Плоскость обзора в даль 1000 wu
     Начальное местоположение в (0f, 0f, 10f).
     Начальное направление взгляда в начло координат.
     */
    private final Camera cam;
    /*
     http://javadoc.jmonkeyengine.org/com/jme3/input/ChaseCamera.html
     public class ChaseCamera
     extends java.lang.Object
     implements ActionListener, AnalogListener, Control

     Камера, которая следует за spatial и может поворачиваться вокруг если перемещать мышь
     Создайте следующую камеру и зарегистрируете ввод если вы используете этот
     конструктор то вам нужно прикрепить камеру к spatial после того как вы сделаете
     spatial.addControl(chaseCamera);
     */
    //private final ChaseCamera chaseCam;
    private final FlyByCamera flyByCam;

    public CameraContext(AppSettings settings, InputManager inputManager,
                         Camera cam, FlyByCamera flyByCam) {

        assert (settings != null);
        this.settings = settings;
        assert (inputManager != null);
        this.inputManager = inputManager;
        assert (cam != null);
        this.cam = cam;
        assert (flyByCam != null);
        this.flyByCam = flyByCam;

        //this.chaseCam = new ChaseCamera(this.cam, this.inputManager);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        //TODO: инициализируйте ваш AppState, например. присоедините spatial-ы к rootNode
        //это вызывается в потоке OpenGL после присоединения AppState

        //this.cam.setFrustumPerspective(116.0f, (settings.getWidth() / settings.getHeight()), 1.0f, 2000.0f);
        this.flyByCam.setMoveSpeed(50);
        this.flyByCam.setEnabled(true);
    }

    /**
     @return  cam(камера)
     */
    public Camera getCam()
    {
        return cam;
    }

    /**
     @return chaseCam(следящая камера)
     */
//    public ChaseCamera getChaseCam()
//    {
//        return chaseCam;
//    }
}
