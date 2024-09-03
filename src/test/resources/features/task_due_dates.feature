Feature: Manage task due dates
  As a user
  I want to set, edit, and view tasks filtered by due dates
  So that I can manage my tasks effectively

  Background:
    Given I am logged into the todo.ly application

  Scenario: Set a due date for a task
    Given I have an existing task "Buy groceries"
    When I set the due date for the task to "2024-11-10"
    Then the task should display the due date "2024-11-10"

  Scenario: Edit the due date of an existing task
    Given I have an existing task "Buy groceries" with a due date of "2024-11-10"
    When I edit the due date of the task to "2024-11-15"
    Then the task should display the due date "2024-11-15"

  Scenario: View tasks filtered by due date
    Given I have multiple tasks with various due dates
    When I filter tasks by the due date "2024-11-11"
    Then only tasks with the due date "2024-11-11" should be displayed
