package com.lyr.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lyr.demo.dao.OptionDao;
import com.lyr.demo.dao.QuestionDao;
import com.lyr.demo.dao.SurveyDao;
import com.lyr.demo.entity.Option;
import com.lyr.demo.entity.Question;
import com.lyr.demo.entity.Survey;
import com.lyr.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private SurveyDao surveyDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private OptionDao optionDao;

    /**
     * 级联保存。下面的操作是标准流程.
     *
     * 操作
     *  1.创建一张问卷。问卷有两个问题，每个问题分别有一个选项。
     *  2.对于单个问题：设置问题的标题，设置问卷属性
     *  3.对于单个选项：设置选项的标题，设置问题属性
     *  4.问题添加选型
     *  5.问卷添加问题
     *  6.保存问卷（不需要手动保存问题和问卷）
     */
    @GetMapping("/test1")
    public Result test1() {
        Result result = new Result();

        Survey survey = new Survey();
        survey.setTitle("s1");

        //新增一个问题1和选项,需要setSurvey()
        Question q1 = new Question();
        q1.setTitle("q1");
        q1.setSurvey(survey);
        //新增一个选项,需要setQuestion()
        Option op1 = new Option();
        op1.setTitle("op1");
        op1.setQuestion(q1);

        // 下面是同样的操作：新增问题2和选项
        Question q2 = new Question();
        q2.setTitle("q2");
        q2.setSurvey(survey);
        Option op2 = new Option();
        op2.setTitle("op2");
        op2.setQuestion(q2);

        //Question类需要主动把Option类加入自己的options属性
        q1.addOption(op1);
        q2.addOption(op2);

        //在执行surveyDao.save(survey)之前，Survey类需要主动把Question类加入自己的questions属性
        survey.addQuestion(q1);
        survey.addQuestion(q2);

        surveyDao.save(survey);

        return result;
    }

    /**
     * 级联删除.删除一个问卷，问卷下面的所有问题和所有选项都将会被删除。
     */
    @GetMapping("/test2")
    public Result test2() {
        Result result = new Result();
        //删除一个问卷（改为数据库对应的问卷id）
        surveyDao.deleteById("4028fe8179ef78b80179ef7968160000");
        return result;
    }

    /**
     * 级联删除。删除一个问题，问题下面的所有选项都会被删除，但是问题所属的问卷不会有任何操作。
     */
    @GetMapping("/test3")
    public Result test3() {
        Result result = new Result();
        //删除一个问题（改为数据库对应的问题id）
        questionDao.deleteById("4028fe8179ef65ce0179ef67eaa90001");
        return result;
    }

    /**
     * 级联删除。删除一个选项，对所属的问题没有影响，对所属的问卷也没有影响
     */
    @GetMapping("/test4")
    public Result test4() {
        Result result = new Result();
        //删除一个选项（改为数据库对应的选项id）
        optionDao.deleteById("4028fe8179ef7cc10179ef7dbdbd0002");
        return result;
    }

    /**
     * 级联查询。查询一个问卷，可以查到所有的选项和所有的问题。
     * 返回的是json数据
     */
     /**
     * 返回的测试数据
     * {
     *     "msg": "成功装载数据",
     *     "code": 0,
     *     "data": {
     *         "questions": [
     *             {
     *                 "options": [
     *                     {
     *                         "id": "4028fe8179ef7e470179ef91863a0002",
     *                         "title": "op1"
     *                     },
     *                     {
     *                         "id": "4028fe8179ef7e470179ef91863a0007",
     *                         "title": "op3"
     *                     }
     *                 ],
     *                 "id": "4028fe8179ef7e470179ef91863a0001",
     *                 "title": "q1"
     *             },
     *             {
     *                 "options": [
     *                     {
     *                         "id": "4028fe8179ef7e470179ef91863a0004",
     *                         "title": "op2"
     *                     },
     *                     {
     *                         "id": "4028fe8179ef7e470179ef91863a0008",
     *                         "title": "op4"
     *                     }
     *                 ],
     *                 "id": "4028fe8179ef7e470179ef91863a0003",
     *                 "title": "q2"
     *             }
     *         ],
     *         "id": "4028fe8179ef7e470179ef9186350000",
     *         "title": "s1"
     *     }
     * }
     *
     */
    @GetMapping("/test5")
    public Result test5() {
        Result result = new Result();
        Survey entity = surveyDao.getOne("4028fe8179ef7e470179ef9186350000");
        if (null != entity) {
            JSONObject all = new JSONObject(); //总的一个json数组，最后使用result.putData(all)
            all.put("id", entity.getId());
            all.put("title", entity.getTitle());
            List<Question> questions = entity.getQuestions();
            JSONArray arrQuesstions = new JSONArray(); // json数组，装进多个question
            int size = questions.size();
            if (0 != size) {
                //循环获取每个问题
                for (int i = 0; i < size; i++) {
                    JSONObject jsonQuestion = new JSONObject(); //一个问题，json形式
                    Question question = questions.get(i);
                    jsonQuestion.put("id", question.getId());
                    jsonQuestion.put("title", question.getTitle());

                    JSONArray arrOptions = new JSONArray(); //json数组，装进多个option
                    List<Option> options = question.getOptions();
                    int opSize = options.size();
                    //循环获取某个问题的选项
                    if (0 != opSize) {
                        for (int j = 0; j < opSize; j++) {
                            JSONObject jsonOp = new JSONObject();
                            Option option = options.get(j);
                            jsonOp.put("id", option.getId());
                            jsonOp.put("title", option.getTitle());
                            arrOptions.add(j, jsonOp);
                        }
                        jsonQuestion.put("options", arrOptions);
                    }
                    arrQuesstions.add(i, jsonQuestion);
                }
                all.put("questions", arrQuesstions);
                return result.putCode(0).putMsg("成功装载数据").putData(all);
            }
        }
        return result;
    }

    /**
     * 级联更新.
     *
     * 目前需要操作的是：可能问卷需要大改。有删除，也有新增。
     *
     * 说明
     *  1.关键： survey.getQuestions().clear(); 如果缺少了这个，则不能删除无关的数据
     *  2.注解@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL,orphanRemoval = true)
     *
     * 操作步骤（新增一个问题，把以前的无关问题清空）
     *  1.拿到一个问卷
     *  2.把该问卷后面的所有问题清空，也就是clear()
     *  3.添加新问题，设置问题的属性，问题添加问卷的属性
     *  4.问卷添加问题
     *  5.保存问卷
     */
    @GetMapping("/test6")
    public Result test6() {
        Result result = new Result();

        Survey survey = surveyDao.getOne("4028fe8179f396280179f39de6c20006");
        survey.getQuestions().clear();

        Question question=new Question();
        question.setTitle("新的问题");
        question.setSurvey(survey);
        survey.addQuestion(question);

        surveyDao.save(survey);

        return result;
    }

    @GetMapping("/test7")
    public Result test7() {
        Result result = new Result();
        return result;
    }

    @GetMapping("/test8")
    public Result test8() {
        Result result = new Result();
        return result;
    }

}
