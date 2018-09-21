<%--
  Created by IntelliJ IDEA.
  User: 100622161
  Date: 2018-8-21
  Time: 19:29
  Describe: 新建任务页面，创建好的任务状态为“待完善或待分配”
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建任务</title>
    <script type="text/javascript">
        $(document)
            .ready(function() {
                $('.ui.menu .ui.dropdown').dropdown({
                    on: 'hover'
                });
                $('.ui.menu a.item')
                    .on('click', function () {
                        $(this)
                            .addClass('active')
                            .siblings()
                            .removeClass('active')
                        ;
                    })
                ;
                $('#addTaskForm')
                    .form({
                    inline: true,
                    on: 'blur',
                    fields: {
                        taskName:{
                            identifier  : 'taskName',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : "任务名称不能为空"
                                }
                            ]
                        }
                    }});
                $('.coupled.modal')
                    .modal({
                        allowMultiple: false
                    })
                ;
                $('.selectPerson.modal')
                    .modal('attach events', '.save.modal .approve.button')
                ;
                //保存按钮响应事件
                $("#mySubmit").on('click',function(){
                        var task = {
                             tName: $("#tName").val(),
                             tTime:$("#tTime").val(),
                             tContent:$("#tContent").val(),
                       };
                    $.ajax({
                        type: 'post',
                        url: 'api/task_center/client/op_add_task',
                        dataType: "json",
                        timeout: 10000,
                        async: false,
                        cache: false,
                        data: task,
                        error : function() {
                            alert('新建失败！');
                        },
                        success: function(){
                            $(".save.modal")
                                .modal('show')
                            ;
                        }
                    });
                })
                ;
                $(".myCal.calendar").calendar({
                    type: 'date',
                    formatter: { // 自定义日期的格式
                        date: function(date, settings) {
                            if (!date) return '';

                            var year  = date.getFullYear();
                            var month = date.getMonth() + 1;
                            var day   = date.getDate();

                            month = month < 10 ? '0'+month : month;
                            day   = day   < 10 ? '0'+day   : day;

                            return year + '-' + month + '-' + day;
                        }
                    }
                });
            });
    </script>
    <script type="text/javascript">
        function initCalendar() {

        }
    </script>
</head>
<body>

<div>
    <a class="ui big green ribbon label">
        <i class="ui add icon"></i>
        新建任务
    </a>
    <p></p>
    <div class="ui content">
        <form class="ui form">
            <div class="required field">
                <h4>任务基本信息</h4>
                <div class="two fields">
                    <div class="three wide field">
                        <label>任务名称：</label>
                        <input id="tName" type="text" placeholder="少于15个字" maxlength="15">
                    </div>
                    <div class="two wide field">
                        <label>任务时长（天）：</label>
                        <input id="tTime" type="number">
                    </div>
                    <div class="eleven wide field">
                        <label>任务内容：</label>
                        <input id="tContent" type="text" placeholder="少于200个字" maxlength="200">
                    </div>
                </div>
            </div>
            <div class="field">
                <div class="fields">
                    <div class="one wide fild">
                        <h4>添加附件：</h4>
                    </div>
                </div>
            </div>
                <div class="field" id="defaultField"></div>
                <div class="filed">
                    <div class="ui form-actions">
                        <div class="fields">
                            <div class="three wide field">
                                <input type="file" placeholder="上传附件...">
                            </div>
                            <div class="nine wide field"></div>
                            <div class="two wide field">
                                <a class="ui black icon button">
                                    <i class="minus circle icon"></i>
                                    取消
                                </a>
                            </div>
                            <div class="two wide field">
                                <a id="mySubmit" class="ui green icon button">
                                    <i class="check circle icon"></i>
                                    保存
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

<div class="ui save coupled mini modal">
    <div class="header">
        <i class="ui check circle icon"></i>
        保存成功
    </div>
    <div class="content">
        <p>任务名称：恒大集团练手系统</p>
        <p>任务描述：这是一个给恒大集团新员工的练手系统</p>
        <p>预期时间：24天</p>
        <p>
            任务附件：资料.zip
            <a class="ui icon button">
                <i class="ui cloud download icon"></i>
                点击下载
            </a>
        </p>
    </div>
    <div class="actions">
        <div class="ui approve blue button">分配人员</div>
        <div class="ui positive button">转到查看任务</div>
    </div>
</div>

<div class="ui selectPerson coupled modal">
    <div class="header">
        <i class="ui random icon"></i>
        任务分配
    </div>
    <div class="content">
        <div class="ui three column doubling grid">
            <div class="two wide column"></div>
            <div class="two wide column">
                <h4>选择角色：</h4>
            </div>
            <div class="four wide column">
                <select name="staff" class="ui fluid dropdown">
                    <option value="">选择角色</option>
                    <option value="staff1">1-杨旭</option>
                    <option value="staff2">2-徐广松</option>
                </select>
            </div>
            <div class="three wide column">
                <h4>选择开始日期：</h4>
            </div>
            <div class="five wide column">
                <div class="ui myCal calendar">
                    <div class="ui icon input"><div class="ui popup calendar"><table class="ui celled center aligned unstackable table seven column day"><thead><tr><th colspan="7"><span class="link">August 2018</span><span class="prev link"><i class="chevron left icon"></i></span><span class="next link"><i class="chevron right icon"></i></span></th></tr><tr><th>S</th><th>M</th><th>T</th><th>W</th><th>T</th><th>F</th><th>S</th></tr></thead><tbody><tr><td class="link adjacent disabled">29</td><td class="link adjacent disabled">30</td><td class="link adjacent disabled">31</td><td class="link">1</td><td class="link">2</td><td class="link">3</td><td class="link">4</td></tr><tr><td class="link">5</td><td class="link">6</td><td class="link">7</td><td class="link">8</td><td class="link">9</td><td class="link">10</td><td class="link">7</td></tr><tr><td class="link">12</td><td class="link">13</td><td class="link">14</td><td class="link">15</td><td class="link">16</td><td class="link">17</td><td class="link">18</td></tr><tr><td class="link">19</td><td class="link">20</td><td class="link">21</td><td class="link today focus">22</td><td class="link">23</td><td class="link">24</td><td class="link">25</td></tr><tr><td class="link">26</td><td class="link">27</td><td class="link">28</td><td class="link">29</td><td class="link">30</td><td class="link">31</td><td class="link adjacent disabled">1</td></tr><tr><td class="link adjacent disabled">2</td><td class="link adjacent disabled">3</td><td class="link adjacent disabled">4</td><td class="link adjacent disabled">5</td><td class="link adjacent disabled">6</td><td class="link adjacent disabled">7</td><td class="link adjacent disabled">8</td></tr></tbody></table></div>
                        <i class="calendar icon"></i>
                        <input type="text" placeholder="未选择日期" value="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="actions">
        <div class="ui positive button">确认</div>
        <div class="ui black deny button">取消</div>
    </div>
</div>

</body>
</html>
