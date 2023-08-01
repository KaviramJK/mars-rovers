package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import marsrovers.Rover;
import marsrovers.Utilities;

import static marsrovers.Utilities.getFacingValue;
import static marsrovers.Utilities.isValidDirection;
import static org.testng.Assert.*;


public class RoverTestStepDef {
    private boolean roverInitializationFailed=false;
   private Rover rover = new Rover();
    @Given("a rover is at position x = {int} and  y = {int} facing direction = {string}")
    public void aRoverIsAtPositionFacing(int x, int y, String facingPosition) {
           rover.setPosition(x, y,getFacingValue(facingPosition));
    }


    @Then("verify the rover position is set as expected position x = {int} and y = {int} facing direction {string}")
    public void verifyTheRoverPositionIsSetAsExpectedPositionXAndYFacingDirection(int x, int y, String direction) {
        assertEquals(x, rover.getX());
        assertEquals(y, rover.getY());
        assertEquals(getFacingValue(direction),rover.getFacing());
    }

    @Then("verify the rover initialization failed")
    public void verifyTheRoverInitializationFailed() {
        assertTrue(roverInitializationFailed);
    }

    

    @When("the rover moves")
    public void theRoverMoves() {
        rover.process("M");
    }


    @When("the rover turns right")
    public void theRoverTurnsRight() {
        rover.process("R");
    }

    @When("the rover turns left")
    public void theRoverTurnsLeft() {
        rover.process("L");
    }

    @When("the rover receives the command {string}")
    public void theRoverReceivesTheCommand(String command) {
        rover.process(command);
    }
}
