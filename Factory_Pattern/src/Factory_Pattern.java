/*
In class-based programming, the factory method pattern is a creational pattern that uses factory
methods to deal with the problem of creating objects without having to specify the exact class
of the object that will be created. This is done by creating objects by calling a factory
method—either specified in an interface and implemented by child classes, or implemented in a
base class and optionally overridden by derived classes—rather than by calling a constructor.
*/
//Creation Interface of Product and Concrete implementation classes of interfaces

//Start
interface Login {
    void FormCreate();
    void ValidateProcess();
}
class GuestLogin implements Login {
    public void FormCreate() {
        System.out.println("(*This a Guest Form of Login*)");
    }
    public void ValidateProcess() {
        System.out.println("(*This a Guest ValidateProcess*)");
    }
}
class WorkerLogin implements Login {
    public void FormCreate() {
        System.out.println("(*This a Worker Form of Login*)");
    }
    public void ValidateProcess() {
        System.out.println("(*This a Worker ValidateProcess*)");
    }
}
//End
//Creation of Abstract Factory and Implementation of Concrete Factories
//start
abstract class LoginFactory {
    public abstract Login createLogin();
}

class GuestLoginFactory extends LoginFactory {
    public Login createLogin() {
        return new GuestLogin();
    }
}

class WorkerLoginFactory extends LoginFactory {
    public Login createLogin() {
        return new WorkerLogin();
    }
}
//end
//Run example
class FactoryMethodPatternRun {
    public static void main(String[] args) {
        System.out.println("\nImplementation of Guest Interface:");
        LoginFactory guestLoginFactory =new GuestLoginFactory();
        Login guest = guestLoginFactory.createLogin();
        guest.FormCreate();
        guest.ValidateProcess();
        System.out.println("\nImplementation of Worker Interface:");
        LoginFactory workerLoginFactory =new GuestLoginFactory();
        Login worker = guestLoginFactory.createLogin();
        worker.FormCreate();
        worker.ValidateProcess();
    }
}



