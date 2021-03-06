package com.evergrande.hdtms.model.teacher;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class TaskUsingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskUsingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTPkIdIsNull() {
            addCriterion("t_pk_id is null");
            return (Criteria) this;
        }

        public Criteria andTPkIdIsNotNull() {
            addCriterion("t_pk_id is not null");
            return (Criteria) this;
        }

        public Criteria andTPkIdEqualTo(Integer value) {
            addCriterion("t_pk_id =", value, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTPkIdNotEqualTo(Integer value) {
            addCriterion("t_pk_id <>", value, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTPkIdGreaterThan(Integer value) {
            addCriterion("t_pk_id >", value, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTPkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_pk_id >=", value, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTPkIdLessThan(Integer value) {
            addCriterion("t_pk_id <", value, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTPkIdLessThanOrEqualTo(Integer value) {
            addCriterion("t_pk_id <=", value, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTPkIdIn(List<Integer> values) {
            addCriterion("t_pk_id in", values, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTPkIdNotIn(List<Integer> values) {
            addCriterion("t_pk_id not in", values, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTPkIdBetween(Integer value1, Integer value2) {
            addCriterion("t_pk_id between", value1, value2, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTPkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("t_pk_id not between", value1, value2, "tPkId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdIsNull() {
            addCriterion("t_task_id is null");
            return (Criteria) this;
        }

        public Criteria andTTaskIdIsNotNull() {
            addCriterion("t_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTTaskIdEqualTo(String value) {
            addCriterion("t_task_id =", value, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdNotEqualTo(String value) {
            addCriterion("t_task_id <>", value, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdGreaterThan(String value) {
            addCriterion("t_task_id >", value, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("t_task_id >=", value, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdLessThan(String value) {
            addCriterion("t_task_id <", value, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdLessThanOrEqualTo(String value) {
            addCriterion("t_task_id <=", value, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdLike(String value) {
            addCriterion("t_task_id like", value, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdNotLike(String value) {
            addCriterion("t_task_id not like", value, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdIn(List<String> values) {
            addCriterion("t_task_id in", values, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdNotIn(List<String> values) {
            addCriterion("t_task_id not in", values, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdBetween(String value1, String value2) {
            addCriterion("t_task_id between", value1, value2, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTaskIdNotBetween(String value1, String value2) {
            addCriterion("t_task_id not between", value1, value2, "tTaskId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdIsNull() {
            addCriterion("t_tutor_id is null");
            return (Criteria) this;
        }

        public Criteria andTTutorIdIsNotNull() {
            addCriterion("t_tutor_id is not null");
            return (Criteria) this;
        }

        public Criteria andTTutorIdEqualTo(String value) {
            addCriterion("t_tutor_id =", value, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdNotEqualTo(String value) {
            addCriterion("t_tutor_id <>", value, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdGreaterThan(String value) {
            addCriterion("t_tutor_id >", value, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdGreaterThanOrEqualTo(String value) {
            addCriterion("t_tutor_id >=", value, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdLessThan(String value) {
            addCriterion("t_tutor_id <", value, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdLessThanOrEqualTo(String value) {
            addCriterion("t_tutor_id <=", value, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdLike(String value) {
            addCriterion("t_tutor_id like", value, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdNotLike(String value) {
            addCriterion("t_tutor_id not like", value, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdIn(List<String> values) {
            addCriterion("t_tutor_id in", values, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdNotIn(List<String> values) {
            addCriterion("t_tutor_id not in", values, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdBetween(String value1, String value2) {
            addCriterion("t_tutor_id between", value1, value2, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTTutorIdNotBetween(String value1, String value2) {
            addCriterion("t_tutor_id not between", value1, value2, "tTutorId");
            return (Criteria) this;
        }

        public Criteria andTStuIdIsNull() {
            addCriterion("t_stu_id is null");
            return (Criteria) this;
        }

        public Criteria andTStuIdIsNotNull() {
            addCriterion("t_stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andTStuIdEqualTo(String value) {
            addCriterion("t_stu_id =", value, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdNotEqualTo(String value) {
            addCriterion("t_stu_id <>", value, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdGreaterThan(String value) {
            addCriterion("t_stu_id >", value, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdGreaterThanOrEqualTo(String value) {
            addCriterion("t_stu_id >=", value, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdLessThan(String value) {
            addCriterion("t_stu_id <", value, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdLessThanOrEqualTo(String value) {
            addCriterion("t_stu_id <=", value, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdLike(String value) {
            addCriterion("t_stu_id like", value, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdNotLike(String value) {
            addCriterion("t_stu_id not like", value, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdIn(List<String> values) {
            addCriterion("t_stu_id in", values, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdNotIn(List<String> values) {
            addCriterion("t_stu_id not in", values, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdBetween(String value1, String value2) {
            addCriterion("t_stu_id between", value1, value2, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTStuIdNotBetween(String value1, String value2) {
            addCriterion("t_stu_id not between", value1, value2, "tStuId");
            return (Criteria) this;
        }

        public Criteria andTNameIsNull() {
            addCriterion("t_name is null");
            return (Criteria) this;
        }

        public Criteria andTNameIsNotNull() {
            addCriterion("t_name is not null");
            return (Criteria) this;
        }

        public Criteria andTNameEqualTo(String value) {
            addCriterion("t_name =", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotEqualTo(String value) {
            addCriterion("t_name <>", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThan(String value) {
            addCriterion("t_name >", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_name >=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThan(String value) {
            addCriterion("t_name <", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThanOrEqualTo(String value) {
            addCriterion("t_name <=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLike(String value) {
            addCriterion("t_name like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotLike(String value) {
            addCriterion("t_name not like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameIn(List<String> values) {
            addCriterion("t_name in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotIn(List<String> values) {
            addCriterion("t_name not in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameBetween(String value1, String value2) {
            addCriterion("t_name between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotBetween(String value1, String value2) {
            addCriterion("t_name not between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTCategoryIsNull() {
            addCriterion("t_category is null");
            return (Criteria) this;
        }

        public Criteria andTCategoryIsNotNull() {
            addCriterion("t_category is not null");
            return (Criteria) this;
        }

        public Criteria andTCategoryEqualTo(Integer value) {
            addCriterion("t_category =", value, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTCategoryNotEqualTo(Integer value) {
            addCriterion("t_category <>", value, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTCategoryGreaterThan(Integer value) {
            addCriterion("t_category >", value, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_category >=", value, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTCategoryLessThan(Integer value) {
            addCriterion("t_category <", value, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("t_category <=", value, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTCategoryIn(List<Integer> values) {
            addCriterion("t_category in", values, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTCategoryNotIn(List<Integer> values) {
            addCriterion("t_category not in", values, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTCategoryBetween(Integer value1, Integer value2) {
            addCriterion("t_category between", value1, value2, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("t_category not between", value1, value2, "tCategory");
            return (Criteria) this;
        }

        public Criteria andTContentIsNull() {
            addCriterion("t_content is null");
            return (Criteria) this;
        }

        public Criteria andTContentIsNotNull() {
            addCriterion("t_content is not null");
            return (Criteria) this;
        }

        public Criteria andTContentEqualTo(String value) {
            addCriterion("t_content =", value, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentNotEqualTo(String value) {
            addCriterion("t_content <>", value, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentGreaterThan(String value) {
            addCriterion("t_content >", value, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentGreaterThanOrEqualTo(String value) {
            addCriterion("t_content >=", value, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentLessThan(String value) {
            addCriterion("t_content <", value, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentLessThanOrEqualTo(String value) {
            addCriterion("t_content <=", value, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentLike(String value) {
            addCriterion("t_content like", value, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentNotLike(String value) {
            addCriterion("t_content not like", value, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentIn(List<String> values) {
            addCriterion("t_content in", values, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentNotIn(List<String> values) {
            addCriterion("t_content not in", values, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentBetween(String value1, String value2) {
            addCriterion("t_content between", value1, value2, "tContent");
            return (Criteria) this;
        }

        public Criteria andTContentNotBetween(String value1, String value2) {
            addCriterion("t_content not between", value1, value2, "tContent");
            return (Criteria) this;
        }

        public Criteria andTProgressIsNull() {
            addCriterion("t_progress is null");
            return (Criteria) this;
        }

        public Criteria andTProgressIsNotNull() {
            addCriterion("t_progress is not null");
            return (Criteria) this;
        }

        public Criteria andTProgressEqualTo(Integer value) {
            addCriterion("t_progress =", value, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTProgressNotEqualTo(Integer value) {
            addCriterion("t_progress <>", value, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTProgressGreaterThan(Integer value) {
            addCriterion("t_progress >", value, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTProgressGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_progress >=", value, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTProgressLessThan(Integer value) {
            addCriterion("t_progress <", value, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTProgressLessThanOrEqualTo(Integer value) {
            addCriterion("t_progress <=", value, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTProgressIn(List<Integer> values) {
            addCriterion("t_progress in", values, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTProgressNotIn(List<Integer> values) {
            addCriterion("t_progress not in", values, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTProgressBetween(Integer value1, Integer value2) {
            addCriterion("t_progress between", value1, value2, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTProgressNotBetween(Integer value1, Integer value2) {
            addCriterion("t_progress not between", value1, value2, "tProgress");
            return (Criteria) this;
        }

        public Criteria andTTimeIsNull() {
            addCriterion("t_time is null");
            return (Criteria) this;
        }

        public Criteria andTTimeIsNotNull() {
            addCriterion("t_time is not null");
            return (Criteria) this;
        }

        public Criteria andTTimeEqualTo(Integer value) {
            addCriterion("t_time =", value, "tTime");
            return (Criteria) this;
        }

        public Criteria andTTimeNotEqualTo(Integer value) {
            addCriterion("t_time <>", value, "tTime");
            return (Criteria) this;
        }

        public Criteria andTTimeGreaterThan(Integer value) {
            addCriterion("t_time >", value, "tTime");
            return (Criteria) this;
        }

        public Criteria andTTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_time >=", value, "tTime");
            return (Criteria) this;
        }

        public Criteria andTTimeLessThan(Integer value) {
            addCriterion("t_time <", value, "tTime");
            return (Criteria) this;
        }

        public Criteria andTTimeLessThanOrEqualTo(Integer value) {
            addCriterion("t_time <=", value, "tTime");
            return (Criteria) this;
        }

        public Criteria andTTimeIn(List<Integer> values) {
            addCriterion("t_time in", values, "tTime");
            return (Criteria) this;
        }

        public Criteria andTTimeNotIn(List<Integer> values) {
            addCriterion("t_time not in", values, "tTime");
            return (Criteria) this;
        }

        public Criteria andTTimeBetween(Integer value1, Integer value2) {
            addCriterion("t_time between", value1, value2, "tTime");
            return (Criteria) this;
        }

        public Criteria andTTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("t_time not between", value1, value2, "tTime");
            return (Criteria) this;
        }

        public Criteria andTFeedbackIsNull() {
            addCriterion("t_feedback is null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackIsNotNull() {
            addCriterion("t_feedback is not null");
            return (Criteria) this;
        }

        public Criteria andTFeedbackEqualTo(String value) {
            addCriterion("t_feedback =", value, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackNotEqualTo(String value) {
            addCriterion("t_feedback <>", value, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackGreaterThan(String value) {
            addCriterion("t_feedback >", value, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackGreaterThanOrEqualTo(String value) {
            addCriterion("t_feedback >=", value, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackLessThan(String value) {
            addCriterion("t_feedback <", value, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackLessThanOrEqualTo(String value) {
            addCriterion("t_feedback <=", value, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackLike(String value) {
            addCriterion("t_feedback like", value, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackNotLike(String value) {
            addCriterion("t_feedback not like", value, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackIn(List<String> values) {
            addCriterion("t_feedback in", values, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackNotIn(List<String> values) {
            addCriterion("t_feedback not in", values, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackBetween(String value1, String value2) {
            addCriterion("t_feedback between", value1, value2, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTFeedbackNotBetween(String value1, String value2) {
            addCriterion("t_feedback not between", value1, value2, "tFeedback");
            return (Criteria) this;
        }

        public Criteria andTStartDateIsNull() {
            addCriterion("t_start_date is null");
            return (Criteria) this;
        }

        public Criteria andTStartDateIsNotNull() {
            addCriterion("t_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andTStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("t_start_date =", value, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("t_start_date <>", value, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("t_start_date >", value, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_start_date >=", value, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTStartDateLessThan(Date value) {
            addCriterionForJDBCDate("t_start_date <", value, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_start_date <=", value, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("t_start_date in", values, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("t_start_date not in", values, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_start_date between", value1, value2, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_start_date not between", value1, value2, "tStartDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateIsNull() {
            addCriterion("t_expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateIsNotNull() {
            addCriterion("t_expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateEqualTo(Date value) {
            addCriterionForJDBCDate("t_expiration_date =", value, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("t_expiration_date <>", value, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("t_expiration_date >", value, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_expiration_date >=", value, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateLessThan(Date value) {
            addCriterionForJDBCDate("t_expiration_date <", value, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_expiration_date <=", value, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateIn(List<Date> values) {
            addCriterionForJDBCDate("t_expiration_date in", values, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("t_expiration_date not in", values, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_expiration_date between", value1, value2, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTExpirationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_expiration_date not between", value1, value2, "tExpirationDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateIsNull() {
            addCriterion("t_finish_date is null");
            return (Criteria) this;
        }

        public Criteria andTFinishDateIsNotNull() {
            addCriterion("t_finish_date is not null");
            return (Criteria) this;
        }

        public Criteria andTFinishDateEqualTo(Date value) {
            addCriterionForJDBCDate("t_finish_date =", value, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("t_finish_date <>", value, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateGreaterThan(Date value) {
            addCriterionForJDBCDate("t_finish_date >", value, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_finish_date >=", value, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateLessThan(Date value) {
            addCriterionForJDBCDate("t_finish_date <", value, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_finish_date <=", value, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateIn(List<Date> values) {
            addCriterionForJDBCDate("t_finish_date in", values, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("t_finish_date not in", values, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_finish_date between", value1, value2, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTFinishDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_finish_date not between", value1, value2, "tFinishDate");
            return (Criteria) this;
        }

        public Criteria andTCreaterIsNull() {
            addCriterion("t_creater is null");
            return (Criteria) this;
        }

        public Criteria andTCreaterIsNotNull() {
            addCriterion("t_creater is not null");
            return (Criteria) this;
        }

        public Criteria andTCreaterEqualTo(String value) {
            addCriterion("t_creater =", value, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterNotEqualTo(String value) {
            addCriterion("t_creater <>", value, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterGreaterThan(String value) {
            addCriterion("t_creater >", value, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("t_creater >=", value, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterLessThan(String value) {
            addCriterion("t_creater <", value, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterLessThanOrEqualTo(String value) {
            addCriterion("t_creater <=", value, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterLike(String value) {
            addCriterion("t_creater like", value, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterNotLike(String value) {
            addCriterion("t_creater not like", value, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterIn(List<String> values) {
            addCriterion("t_creater in", values, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterNotIn(List<String> values) {
            addCriterion("t_creater not in", values, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterBetween(String value1, String value2) {
            addCriterion("t_creater between", value1, value2, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreaterNotBetween(String value1, String value2) {
            addCriterion("t_creater not between", value1, value2, "tCreater");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeIsNull() {
            addCriterion("t_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeIsNotNull() {
            addCriterion("t_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeEqualTo(Date value) {
            addCriterion("t_create_time =", value, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeNotEqualTo(Date value) {
            addCriterion("t_create_time <>", value, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeGreaterThan(Date value) {
            addCriterion("t_create_time >", value, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("t_create_time >=", value, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeLessThan(Date value) {
            addCriterion("t_create_time <", value, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("t_create_time <=", value, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeIn(List<Date> values) {
            addCriterion("t_create_time in", values, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeNotIn(List<Date> values) {
            addCriterion("t_create_time not in", values, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeBetween(Date value1, Date value2) {
            addCriterion("t_create_time between", value1, value2, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("t_create_time not between", value1, value2, "tCreateTime");
            return (Criteria) this;
        }

        public Criteria andTOperatorIsNull() {
            addCriterion("t_operator is null");
            return (Criteria) this;
        }

        public Criteria andTOperatorIsNotNull() {
            addCriterion("t_operator is not null");
            return (Criteria) this;
        }

        public Criteria andTOperatorEqualTo(String value) {
            addCriterion("t_operator =", value, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorNotEqualTo(String value) {
            addCriterion("t_operator <>", value, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorGreaterThan(String value) {
            addCriterion("t_operator >", value, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("t_operator >=", value, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorLessThan(String value) {
            addCriterion("t_operator <", value, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorLessThanOrEqualTo(String value) {
            addCriterion("t_operator <=", value, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorLike(String value) {
            addCriterion("t_operator like", value, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorNotLike(String value) {
            addCriterion("t_operator not like", value, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorIn(List<String> values) {
            addCriterion("t_operator in", values, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorNotIn(List<String> values) {
            addCriterion("t_operator not in", values, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorBetween(String value1, String value2) {
            addCriterion("t_operator between", value1, value2, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperatorNotBetween(String value1, String value2) {
            addCriterion("t_operator not between", value1, value2, "tOperator");
            return (Criteria) this;
        }

        public Criteria andTOperateDateIsNull() {
            addCriterion("t_operate_date is null");
            return (Criteria) this;
        }

        public Criteria andTOperateDateIsNotNull() {
            addCriterion("t_operate_date is not null");
            return (Criteria) this;
        }

        public Criteria andTOperateDateEqualTo(Date value) {
            addCriterion("t_operate_date =", value, "tOperateDate");
            return (Criteria) this;
        }

        public Criteria andTOperateDateNotEqualTo(Date value) {
            addCriterion("t_operate_date <>", value, "tOperateDate");
            return (Criteria) this;
        }

        public Criteria andTOperateDateGreaterThan(Date value) {
            addCriterion("t_operate_date >", value, "tOperateDate");
            return (Criteria) this;
        }

        public Criteria andTOperateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("t_operate_date >=", value, "tOperateDate");
            return (Criteria) this;
        }

        public Criteria andTOperateDateLessThan(Date value) {
            addCriterion("t_operate_date <", value, "tOperateDate");
            return (Criteria) this;
        }

        public Criteria andTOperateDateLessThanOrEqualTo(Date value) {
            addCriterion("t_operate_date <=", value, "tOperateDate");
            return (Criteria) this;
        }

        public Criteria andTOperateDateIn(List<Date> values) {
            addCriterion("t_operate_date in", values, "tOperateDate");
            return (Criteria) this;
        }

        public Criteria andTOperateDateNotIn(List<Date> values) {
            addCriterion("t_operate_date not in", values, "tOperateDate");
            return (Criteria) this;
        }

        public Criteria andTOperateDateBetween(Date value1, Date value2) {
            addCriterion("t_operate_date between", value1, value2, "tOperateDate");
            return (Criteria) this;
        }

        public Criteria andTOperateDateNotBetween(Date value1, Date value2) {
            addCriterion("t_operate_date not between", value1, value2, "tOperateDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}