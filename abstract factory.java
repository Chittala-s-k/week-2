interface Doors
{
    public function getDescription();
}

class WoodenDoor implements Doors
{
    public function getDescription()
    {
        echo 'I am a wooden door';
    }
}

class IronDoor implements Doors
{
    public function getDescription()
    {
        echo 'I am an iron door';
    }
}

Then we have some fitting experts for each door type

interface DoorFittingExpert
{
    public function getDescription();
}

class Welder implements DoorFittingExpert
{
    public function getDescription()
    {
        echo 'I can only fit iron doors';
    }
}

class Carpenter implements DoorFittingExpert
{
    public function getDescription()
    {
        echo 'I can only fit wooden doors';
    }
}


Now we have the abstract factory that would let us make the family of related objects i.e. wooden door factory would create a wooden door and wooden door fitting expert and an iron door factory would create an iron door and iron door fitting expert. 

interface DoorFactory
{
    public function makeDoor(): Doors;
    public function makeFittingExpert(): DoorFittingExpert;
}

// Wooden factory to return carpenter and wooden door
class WoodenDoorFactory implements DoorFactory
{
    public function makeDoor(): Doors
    {
        return new WoodenDoor();
    }

    public function makeFittingExpert(): DoorFittingExpert
    {
        return new Carpenter();
    }
}

// Iron door factory to get the iron door and the relevant fitting expert
class IronDoorFactory implements DoorFactory
{
    public function makeDoor(): Doors
    {
        return new IronDoor();
    }

    public function makeFittingExpert(): DoorFittingExpert
    {
        return new Welder();
    }
}
