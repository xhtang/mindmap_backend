package application.repository;

import application.entity.StudentAnswerForShortAnswer;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;
import java.util.Set;

/**
 * Creator: DreamBoy
 * Date: 2018/6/2.
 */
public interface StudentAnswerForShortAnswerRepository
        extends CrudRepository<StudentAnswerForShortAnswer, Long>{
    StudentAnswerForShortAnswer findById(long id);

    @Query("MATCH (s:Student)-[r:resolve]->(q:ShortAnswerQuestion) WHERE ID(q)= {0}" +
            "RETURN r.answer AS answer, s.name AS name")
    Iterable<Map<String, Object>> findAnswersToQuestion(long questionId);

    @Query("MATCH (n:Student)-[:resolve]->(q:StudentAnswerForShortAnswer) WHERE ID(n)={0}" +
            "RETURN q")
    Set<StudentAnswerForShortAnswer> findByStudent_Id(long studentId);

    @Query("MATCH (n:Student)-[r:resolve]->(q:ShortAnswerQuestion) WHERE ID(n)={0}" +
            "AND ID(q) = {1} RETURN r")
    StudentAnswerForShortAnswer findByStudentAndQuestion(long studentId, long questionId);

}
