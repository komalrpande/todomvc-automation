Feature: Complete Task

  Background:
    Given ToDoMVC application is launched

  @completeAllTasks @testpack
  Scenario: Verify that the user is able to complete all tasks
    When Add Multiple Tasks
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
    And Complete all Tasks
    Then Validate that the tasks are completed successfully
      | TaskName     |
      | Plan Test    |
      | Prepare Test |

  @clearCompletedTask @testpack
  Scenario: Verify that the user is able to clear Completed tasks
    When Add Multiple Tasks
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
      | Execute Test |
      | Deliver Test |
    And Complete all Tasks
    And Clear Completed Tasks
    Then Validate that the Completed tasks are cleared successfully
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
      | Execute Test |
      | Deliver Test |


