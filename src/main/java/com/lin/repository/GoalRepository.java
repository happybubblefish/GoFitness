package com.lin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lin.model.Goal;
import com.lin.model.GoalReport;

@Repository("goalRepository")
public interface GoalRepository extends JpaRepository<Goal, Long> {

	@Query("Select new com.lin.model.GoalReport(g.id, g.date, g.minutes, e.minutes, m.username, e.activity, e.sets, e.reps) "
			+ "from Goal g, Exercise e, Member m where g.id = e.goal.id and g.member.id = m.id")
	List<GoalReport> findAllGoalReports();

	@Query("Select new com.lin.model.GoalReport(g.id, g.date, g.minutes, e.minutes, m.username, e.activity, e.sets, e.reps) "
			+ "from Goal g, Exercise e, Member m where g.id = e.goal.id and g.member.id = m.id "
			+ "and m.username = ?1")
	List<GoalReport> findUserGoalReports(String username);

	@Query("Select new com.lin.model.GoalReport(g.id, g.date, g.minutes, e.minutes, m.username, e.activity, e.sets, e.reps) "
			+ "from Goal g, ActualExercise e, Member m where g.id = e.goalId and g.member.id = m.id "
			+ "and m.username = ?1")
	List<GoalReport> findUserActualExerciseGoalReports(String username);

}
