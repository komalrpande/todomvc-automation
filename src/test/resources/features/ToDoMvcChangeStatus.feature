Feature: Change Task Status

  Background:
    Given ToDoMVC application is launched

  @changeTaskStatus  @testpack
  Scenario Outline: Verify that the user is able to change task status
    When Add To do "<Task>"
    And Change "<Task>" "<Status>"
    Then Validate that the "<Task>" "<Status>" is updated successfully
    Examples:
      | Task                 | Status   |
      | ActivetoCompleteTest | Complete |
      | CompletetoActiveTest | Active   |