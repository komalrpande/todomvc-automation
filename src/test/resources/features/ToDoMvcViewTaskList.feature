Feature: View Task List

  Background:
    Given ToDoMVC application is launched

  @ViewTaskList @testpack
  Scenario: Verify that the user is able to view Task List
    When Add Multiple Tasks
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
      | Execute Test |
      | Deliver Test |
    And Complete Multiple Tasks
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
    And Go To List
      | List      |
      | Completed |
    Then Validate that the tasks are completed successfully
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
    And Go To List
      | List   |
      | Active |
    And Validate that the tasks are Active
      | TaskName     |
      | Execute Test |
      | Deliver Test |
    And Go To List
      | List |
      | All  |
    And Validate that all tasks are displayed
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
      | Execute Test |
      | Deliver Test |

  @todocount_addTask  @testpack
  Scenario: Verify that the count of active status is updated on adding task
    When Add Multiple Tasks
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
    And Check the number of items left
    When Add Multiple Tasks
      | TaskName     |
      | Execute Test |
    Then Validate that the number of items left is updated after adding task

  @todocount_removeTask @testpack
  Scenario: Verify that the count of active status is updated on removing task
    When Add Multiple Tasks
      | TaskName     |
      | Plan Test    |
      | Prepare Test |
      | Test         |
    And Check the number of items left
    And Remove active Task
      | TaskName  |
      | Plan Test |
    Then Validate that the number of items left is updated after removing task