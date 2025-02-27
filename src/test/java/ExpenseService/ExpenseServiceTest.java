package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ExpenseService.Expense.ExpenseType.*;
import static ExpenseService.Project.ProjectType.EXTERNAL;
import static ExpenseService.Project.ProjectType.INTERNAL;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(INTERNAL,"project");
       // ExpenseService expenseService = new ExpenseService();

        // when
        ExpenseType result =  ExpenseService.getExpenseCodeByProjectTypeAndName(project);

        // then
        Assertions.assertEquals(result,INTERNAL_PROJECT_EXPENSE);

    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL,"Project A");

        // when
        ExpenseType result =  ExpenseService.getExpenseCodeByProjectTypeAndName(project);

        // then
        Assertions.assertEquals(result,EXPENSE_TYPE_A);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL,"Project B");

        // when
        ExpenseType result =  ExpenseService.getExpenseCodeByProjectTypeAndName(project);

        // then
        Assertions.assertEquals(result,EXPENSE_TYPE_B);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL,"Project C");
        // when
        ExpenseType result =  ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        Assertions.assertEquals(result,OTHER_EXPENSE);

    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() throws UnexpectedProjectTypeException {
        // given
//        Project project = new Project(EXTERNAL,"Project C");
        Project project =mock (Project.class);
        // when
//        ExpenseType result =  ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        //doThrow(new UnexpectedProjectTypeException("You enter invalid project type")).when(project).getProjectType() != INTERNAL

        // then
//        when(project.getProjectType() != INTERNAL && project.getProjectType() != EXTERNAL).thenThrow(new UnexpectedProjectTypeException("You enter invalid project type"));
        when(ExpenseService.getExpenseCodeByProjectTypeAndName(project)).thenThrow(new UnexpectedProjectTypeException("You enter invalid project type"));
    }
}