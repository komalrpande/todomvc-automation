Feature: Add Task in ToDo List

  Background:
    Given ToDoMVC application is launched

  @addtask  @testpack
  Scenario Outline: Verify that the user is able to add task successfully
    When Add To do "<Task>"
    Then Validate that the "<Task>" is added successfully
    Examples:
      | Task   |
      | Test   |
      | Test@1 |

  @addMultipleTask  @testpack
  Scenario: Verify that the user is able to add multiple task successfully
    When Add Multiple Tasks
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
      | Execute Test |
      | Deliver Test |
    Then Validate that multiple tasks are added successfully
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
      | Execute Test |
      | Deliver Test |


