package com.siddharth.quiz_service.service;

import com.siddharth.quiz_service.dao.QuizDao;
import com.siddharth.quiz_service.feign.QuizInterface;
import com.siddharth.quiz_service.model.QuestionWrapper;
import com.siddharth.quiz_service.model.Quiz;
import com.siddharth.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        /*Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();*/
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        /*for (Question question : questionsFromDB) {
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionsForUser.add(questionWrapper);
        }*/

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        // List<Question> questions = quiz.getQuestions();

        int correctAnswers = 0;
        /*int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(questions.get(i).getRightAnswer()))
                correctAnswers++;
            i++;
        }*/

        return new ResponseEntity<>(correctAnswers, HttpStatus.OK);
    }
}
