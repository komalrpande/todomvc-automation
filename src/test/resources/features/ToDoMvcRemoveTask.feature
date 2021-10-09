Feature: Remove Task

  Background:
    Given ToDoMVC application is launched

  @removeActiveTask @testpack
  Scenario Outline: Verify that the user is able to remove Active task
    When Add To do "<Task>"
    And Remove active "<Task>"
    Then Validate that the "<Task>" is removed successfully
    Examples:
      | Task |
      | Test |

  @removeCompletedTask  @testpack
  Scenario Outline: Verify that the user is able to remove Completed task
    When Add To do "<Task>"
    And Complete active "<Task>"
    And Remove Completed "<Task>"
    Then Validate that the "<Task>" is removed successfully
    Examples:
      | Task         |
      | completeTest |


