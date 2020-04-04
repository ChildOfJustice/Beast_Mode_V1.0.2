//package gui;
//
//import com.jme3.input.KeyInput;
//import com.jme3.input.controls.KeyTrigger;
//import com.jme3.math.FastMath;
//import core.application.ApplicationContext;
//public class keyInputSys {
//
//    static public void setUpKeys() {
//        ApplicationContext.globalInputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
//        ApplicationContext.globalInputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
//        ApplicationContext.globalInputManager.addMapping("Forward", new KeyTrigger(KeyInput.KEY_W));
//        ApplicationContext.globalInputManager.addMapping("Backward", new KeyTrigger(KeyInput.KEY_S));
//        ApplicationContext.globalInputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
//        ApplicationContext.globalInputManager.addListener(Core.mainApplication, "Left");
//        ApplicationContext.globalInputManager.addListener(Core.mainApplication, "Right");
//        ApplicationContext.globalInputManager.addListener(Core.mainApplication, "Forward");
//        ApplicationContext.globalInputManager.addListener(Core.mainApplication, "Backward");
//        ApplicationContext.globalInputManager.addListener(Core.mainApplication, "Jump");
//    }
//
//    public static void analyzeAction(String binding, boolean isPressed) {
//        switch (binding) {
//            case "Left":
//                if (isPressed) {
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.rightDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, FastMath.PI, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.leftDirection;
//                    }
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.backwardDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI/2, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.leftDirection;
//                    }
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.forwardDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, FastMath.PI/2, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.leftDirection;
//                    }
//                }
//
//                ApplicationContext.currentPlayer.left = isPressed;
//                break;
//            case "Right":
//                if (isPressed) {
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.leftDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.rightDirection;
//                    }
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.backwardDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, FastMath.PI/2, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.rightDirection;
//                    }
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.forwardDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI/2, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.rightDirection;
//                    }
//                }
//
//                ApplicationContext.currentPlayer.right = isPressed;
//                break;
//            case "Forward":
//                if (isPressed) {
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.leftDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI/2, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.forwardDirection;
//                    }
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.backwardDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, FastMath.PI, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.forwardDirection;
//                    }
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.rightDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, FastMath.PI/2, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.forwardDirection;
//                    }
//                }
//
//                ApplicationContext.currentPlayer.forward = isPressed;
//                break;
//            case "Backward":
//                if (isPressed) {
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.leftDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, FastMath.PI/2, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.backwardDirection;
//                    }
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.forwardDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, FastMath.PI, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.backwardDirection;
//                    }
//                    if(ApplicationContext.currentPlayer.direction == CurrentPlayer.rightDirection) {
//                        ApplicationContext.currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI/2, 0);
//                        ApplicationContext.currentPlayer.direction = CurrentPlayer.backwardDirection;
//                    }
//                }
//
//                ApplicationContext.currentPlayer.backward = isPressed;
//                break;
//            case "Jump":
//                ApplicationContext.currentPlayer.jumpState = true;
//                break;
//        }
//    }
//}
