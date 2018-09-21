<%--
  Created by IntelliJ IDEA.
  User: 100622161
  Date: 2018-8-22
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/dist/simpleDateFormat.js"></script>
    <script type="text/javascript">
        /*用于检索的参数*/
        var pageNo = 1;
        var pageNum = 10;
        var startDate = "";
        var endDate = "";
        var taskName = "";
        var stateStr = "1-2-3";

        function initCalendar() {
            $('.myCal.calendar').calendar({
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
        }
        function clearDate() {
            //点击按键之后清空日期的选择
            $("#searchTime1").val("");
            $("#searchTime2").val("");
            $("#inputSearchTaskName").val("");
        }
        function clearTable() {
            $("#tbody").html("");
        }
        function initMenu(){
            $('.ui.dropdown')
                .dropdown({
                    allowAdditions: true
                })
            ;
            $(".ui.menu a.item")
                .on('click', function() {
                    $(this)
                        .addClass('active')
                        .siblings()
                        .removeClass('active')
                    ;
                    var datatab = $(this).attr("data-tab");
                    $("[data-pop='"+datatab+"']")
                        .addClass('active')
                        .siblings()
                        .removeClass('active')
                    ;
                })
            ;
            $("tr")
                .on('click', function() {
                    $(this)
                        .addClass('active')
                        .siblings()
                        .removeClass('active')
                    ;
                })
            ;

        }
        function editDetails() {
            $(".editDetails.modal")
                .modal('show')
            ;
        }
        function showDetails(){
            $(".detail.modal")
                .modal('show')
            ;
        }
        function showStuDetail(){
            $(".stuDetail.modal")
                .modal('show')
            ;
        }
        function updateTask() {
            $(".updateTask.modal")
                .modal('show')
            ;
        }
        function masterPerson() {
            $(".masterPerson.modal")
                .modal('show')
            ;
        }
        function loadTable(task) {
            var state = null;
            var color = null;
            var datatool = null;
            var icon = null;
            var fmt = SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            var createTime = fmt.format(task.tCreateTime);//String 类型
            var operateTime = fmt.format(task.tOperateDate);
            switch (task.tState){
                case 1: state = "草稿"; color = "#ffd700"; datatool = "设为废弃"; icon = "ui toggle on icon"; break;
                case 2: state = "使用中"; color = "#7fff00"; datatool = "设为废弃"; icon = "ui toggle on icon"; break;
                case 3: state = "废弃"; color = "#dc143c"; datatool = "设为启用"; icon = "ui toggle off icon"; break;
                default:break;
            }
            $("#tbody").append("<tr>\n" +
                "                        <td>"+task.tName+"</td>\n" +
                "                        <td><font color=\""+color+"\">"+state+"</font></td>\n" +
                "                        <td>"+task.tTime+"</td>\n" +
                "                        <td>"+createTime+"</td>\n" +
                "                        <td>"+operateTime+"</td>\n" +
                "                        <td>\n" +
                "                            <a data-tooltip=\"编辑\">\n" +
                "                                <i class=\"ui pencil alternate outline icon\" onclick=\"editDetails()\"></i>\n" +
                "                            </a>\n" +
                "                            <a data-tooltip=\""+datatool+"\">\n" +
                "                                <i class=\""+icon+"\" ></i>\n" +
                "                            </a>\n" +
                "                            <a data-tooltip=\"详细信息\" disabled=\"true\" onclick=\"showStuDetail()\">\n" +
                "                                <i class=\"ui list alternate outline icon\"></i>\n" +
                "                            </a>\n" +
                "                            <a data-tooltip=\"查看人员\" onclick=\"masterPerson()\">\n" +
                "                                <i class=\"ui user icon\" ></i>\n" +
                "                            </a>\n" +
                "                        </td>\n" +
                "                    </tr>");
        }
        function getAllCreateTask() {
            clearTable();
            $.ajax({
                type: 'post',
                url: 'api/task_center/client/op_task_built',
                success: function (data) {
                    var taskList = eval(data).rows;
                    $.each(taskList, function (i, task) {
                        loadTable(task);
                    });
                }
            });
            initMenu();/* no use ? */
        }
        function searchTask() {
            $("#startDate").val($("#searchTime1").val());
            $("#endDate").val($("#searchTime2").val());
            $("#taskName").val($("#inputSearchTaskName").val());
            $("#stateStr").val($("#selectCreateTask").val());
            $("#pageNo").val(1);
            $("#pageNum").val(1);
            clearTable();
            $.ajax({
                type: 'post',
                url: 'api/task_center/client/op_task_built_condition',
                dataType: 'json',
                timeout: 10000,
                async: false,
                cache: false,
                data: $("#searchBar1").serialize(),
                success: function (data) {
                    var taskList = eval(data).rows;
                    $.each(taskList, function (i, task) {
                        loadTable(task);
                    });
                }
            });
        }
    </script>
    <script type="text/javascript">
        $(document)
            .ready(function() {
                //$("table").tablesort();
                initCalendar();
                initMenu();
            })
        ;
    </script>
</head>
<body>

<div class="main ui container">
    <div id="loading" style="text-align: center; display: none;">
        <img src="/dist/assets/images/loading.gif">
        <br>
        <label>加载中...</label>
    </div>
    <div id="container" style="display: block;">
        <a class="ui big blue ribbon label">
            <i class="ui exclamation circle icon"></i>
            查看任务
        </a>
        <div class="ui one column doubling grid">
            <div class="sixteen wide column">
                <div class="ui top tabular menu">
                    <div class="right menu">
                        <a class="item"  data-tab="stuTaskState">学生任务界面</a>
                        <a class="item active"  data-tab="taskState1" onclick="getAllCreateTask()">我创建的任务</a>
                        <a class="item" data-tab="taskState2">我交办的任务</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="ui bottom attached tab" data-pop="stuTaskState">
            <div class="ui segment">
                <div class="ui three column doubling grid">
                    <div class="two wide column"></div>
                    <div class="two wide column">
                        <h4>指定日期区间：</h4>
                    </div>
                    <div class="four wide column">
                        <div class="ui myCal calendar">
                            <div class="ui icon input"><div class="ui popup calendar"><table class="ui celled center aligned unstackable table seven column day"><thead><tr><th colspan="7"><span class="link">August 2018</span><span class="prev link"><i class="chevron left icon"></i></span><span class="next link"><i class="chevron right icon"></i></span></th></tr><tr><th>S</th><th>M</th><th>T</th><th>W</th><th>T</th><th>F</th><th>S</th></tr></thead><tbody><tr><td class="link adjacent disabled">29</td><td class="link adjacent disabled">30</td><td class="link adjacent disabled">31</td><td class="link">1</td><td class="link">2</td><td class="link">3</td><td class="link">4</td></tr><tr><td class="link">5</td><td class="link">6</td><td class="link">7</td><td class="link">8</td><td class="link">9</td><td class="link">10</td><td class="link">7</td></tr><tr><td class="link">12</td><td class="link">13</td><td class="link">14</td><td class="link">15</td><td class="link">16</td><td class="link">17</td><td class="link">18</td></tr><tr><td class="link">19</td><td class="link">20</td><td class="link">21</td><td class="link today focus">22</td><td class="link">23</td><td class="link">24</td><td class="link">25</td></tr><tr><td class="link">26</td><td class="link">27</td><td class="link">28</td><td class="link">29</td><td class="link">30</td><td class="link">31</td><td class="link adjacent disabled">1</td></tr><tr><td class="link adjacent disabled">2</td><td class="link adjacent disabled">3</td><td class="link adjacent disabled">4</td><td class="link adjacent disabled">5</td><td class="link adjacent disabled">6</td><td class="link adjacent disabled">7</td><td class="link adjacent disabled">8</td></tr></tbody></table></div>
                                <i class="calendar icon"></i>
                                <input id="searchTime0-1" type="text" placeholder="选择起始日期" value="">
                            </div>
                        </div>
                    </div>
                    <div class="four wide column">
                        <div class="ui myCal calendar">
                            <div class="ui icon input"><div class="ui popup calendar"><table class="ui celled center aligned unstackable table seven column day"><thead><tr><th colspan="7"><span class="link">August 2018</span><span class="prev link"><i class="chevron left icon"></i></span><span class="next link"><i class="chevron right icon"></i></span></th></tr><tr><th>S</th><th>M</th><th>T</th><th>W</th><th>T</th><th>F</th><th>S</th></tr></thead><tbody><tr><td class="link adjacent disabled">29</td><td class="link adjacent disabled">30</td><td class="link adjacent disabled">31</td><td class="link">1</td><td class="link">2</td><td class="link">3</td><td class="link">4</td></tr><tr><td class="link">5</td><td class="link">6</td><td class="link">7</td><td class="link">8</td><td class="link">9</td><td class="link">10</td><td class="link">7</td></tr><tr><td class="link">12</td><td class="link">13</td><td class="link">14</td><td class="link">15</td><td class="link">16</td><td class="link">17</td><td class="link">18</td></tr><tr><td class="link">19</td><td class="link">20</td><td class="link">21</td><td class="link today focus">22</td><td class="link">23</td><td class="link">24</td><td class="link">25</td></tr><tr><td class="link">26</td><td class="link">27</td><td class="link">28</td><td class="link">29</td><td class="link">30</td><td class="link">31</td><td class="link adjacent disabled">1</td></tr><tr><td class="link adjacent disabled">2</td><td class="link adjacent disabled">3</td><td class="link adjacent disabled">4</td><td class="link adjacent disabled">5</td><td class="link adjacent disabled">6</td><td class="link adjacent disabled">7</td><td class="link adjacent disabled">8</td></tr></tbody></table></div>
                                <i class="calendar icon"></i>
                                <input id="searchTime0-2" type="text" placeholder="选择结束日期" value="">
                            </div>
                        </div>
                    </div>
                    <div class="two wide column"></div>
                    <div class="two wide column">
                        <div class="ui buttons">
                            <div class="ui primary icon button" onclick="clearDate()" data-tooltip="清空">
                                <i class="ui delete icon"></i>
                            </div>
                            <div class="or"></div>
                            <div class="ui green icon button" data-tooltip="检索">
                                <i class="ui search icon"></i>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="ui two column doubling grid">
                    <div class="ui four wide column"></div>
                    <div class="ui four wide column">
                        <div class="ui icon input">
                            <input id="inputNameOrId0" type="text" placeholder="可搜索任务名称">
                            <i class="search icon"></i>
                        </div>
                        <div class="results"></div>
                    </div>
                    <div class="ui six wide column">
                        <select name="" multiple="" class="ui fluid dropdown">
                            <option value="">选择任务状态</option>
                            <option value="asdfde">待办任务</option>
                            <option value="dxvdsd">进行中任务</option>
                            <option value="dafdgb">历史任务</option>
                        </select>
                    </div>
                </div>
                <br/>
            </div>
            <table class="ui left aligned sortable table">
                <thead>
                <tr>
                    <th>任务名称</th>
                    <th>任务状态</th>
                    <th>交办时间</th>
                    <th>计划完成时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody0">
                <tr class="active">
                    <td>练手系统1</td>
                    <td><font color="#ffd700">已完成</font></td>
                    <td>2018-8-22 10:28</td>
                    <td>2018-8-22 10:28</td>
                    <td>
                        <a data-tooltip="接受任务">
                            <i class="ui play icon"></i>
                        </a>
                        <a data-tooltip="提交完成">
                            <i class="ui check icon"></i>
                        </a>
                        <a data-tooltip="查看详情" onclick="showStuDetail()">
                            <i class="ui list alternate outline icon"></i>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td>练手系统2</td>
                    <td><font color="#7fff00">进行中</font></td>
                    <td>2018-8-22 10:28</td>
                    <td>2018-8-22 10:28</td>
                    <td>
                        <a data-tooltip="接受任务">
                            <i class="ui play icon"></i>
                        </a>
                        <a data-tooltip="提交完成" onclick="updateTask()">
                            <i class="ui check icon"></i>
                        </a>
                        <a data-tooltip="查看详情" onclick="showStuDetail()">
                            <i class="ui list alternate outline icon"></i>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td>练手系统3</td>
                    <td><font color="#dc143c">待办任务</font></td>
                    <td>2018-8-22 10:28</td>
                    <td>2018-8-22 10:28</td>
                    <td>
                        <a data-tooltip="接受任务">
                            <i class="ui play icon"></i>
                        </a>
                        <a data-tooltip="提交完成">
                            <i class="ui check icon"></i>
                        </a>
                        <a data-tooltip="查看详情" onclick="showStuDetail()">
                            <i class="ui list alternate outline icon"></i>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td>练手系统4</td>
                    <td><font color="gold">已完成</font></td>
                    <td>2018-8-22 10:28</td>
                    <td>2018-8-22 10:28</td>
                    <td>
                        <a data-tooltip="接受任务">
                            <i class="ui play icon"></i>
                        </a>
                        <a data-tooltip="提交完成">
                            <i class="ui check icon"></i>
                        </a>
                        <a data-tooltip="查看详情" onclick="showStuDetail()">
                            <i class="ui list alternate outline icon"></i>
                        </a>
                    </td>
                </tr>
                </tbody>
                <tfoot id="tfoot0">
                <tr>
                    <th colspan="1">
                        每页显示
                        <div class="ui compact selection dropdown hidden" tabindex="0">
                            <select id="selectPageNum0">
                                <option value="10" selected="">10</option>
                                <option value="20">20</option>
                                <option value="30">30</option>
                            </select>
                            <i class="dropdown icon"></i>
                            <div class="text hidden">10</div>
                            <div class="menu hidden" tabindex="-1">
                                <div class="item active selected hidden" data-value="10">10</div>
                                <div class="item hidden" data-value="20">20</div>
                                <div class="item hidden" data-value="30">30</div>
                            </div>
                        </div>
                    </th>
                    <th colspan="1"></th>
                    <th colspan="2">
                        <div class="ui pagination menu hidden">
                            <a class="item active disabled" id="pageMessage0">第1页-（共1页）</a>
                            <a class="item disabled" id="previousPage0">
                                <i class="ui left chevron icon"></i>
                            </a>
                            <a class="item disabled" id="nextPage0">
                                <i class="ui right chevron icon"></i>
                            </a>
                        </div>
                    </th>
                    <th colspan="1">
                        跳转到：
                        <div class="ui compact selection dropdown hidden" tabindex="0">
                            <select id="gotoPage0">
                                <option value="1" selected="">1</option>
                            </select>
                            <i class="dropdown icon"></i>
                            <div class="text hidden">1</div>
                            <div class="menu hidden" tabindex="-1">
                                <div class="item active selected hidden" data-value="1">1</div>
                            </div>
                        </div>
                    </th>
                </tr>
                </tfoot>
            </table>
        </div>

        <div class="ui bottom attached tab active" data-pop="taskState1">
            <div class="ui segment">
                <div class="ui three column doubling grid">
                    <div class="two wide column"></div>
                    <div class="two wide column">
                        <h4>指定日期区间：</h4>
                    </div>
                    <div class="four wide column">
                        <div class="ui myCal calendar">
                            <div class="ui icon input"><div class="ui popup calendar"><table class="ui celled center aligned unstackable table seven column day"><thead><tr><th colspan="7"><span class="link">August 2018</span><span class="prev link"><i class="chevron left icon"></i></span><span class="next link"><i class="chevron right icon"></i></span></th></tr><tr><th>S</th><th>M</th><th>T</th><th>W</th><th>T</th><th>F</th><th>S</th></tr></thead><tbody><tr><td class="link adjacent disabled">29</td><td class="link adjacent disabled">30</td><td class="link adjacent disabled">31</td><td class="link">1</td><td class="link">2</td><td class="link">3</td><td class="link">4</td></tr><tr><td class="link">5</td><td class="link">6</td><td class="link">7</td><td class="link">8</td><td class="link">9</td><td class="link">10</td><td class="link">7</td></tr><tr><td class="link">12</td><td class="link">13</td><td class="link">14</td><td class="link">15</td><td class="link">16</td><td class="link">17</td><td class="link">18</td></tr><tr><td class="link">19</td><td class="link">20</td><td class="link">21</td><td class="link today focus">22</td><td class="link">23</td><td class="link">24</td><td class="link">25</td></tr><tr><td class="link">26</td><td class="link">27</td><td class="link">28</td><td class="link">29</td><td class="link">30</td><td class="link">31</td><td class="link adjacent disabled">1</td></tr><tr><td class="link adjacent disabled">2</td><td class="link adjacent disabled">3</td><td class="link adjacent disabled">4</td><td class="link adjacent disabled">5</td><td class="link adjacent disabled">6</td><td class="link adjacent disabled">7</td><td class="link adjacent disabled">8</td></tr></tbody></table></div>
                                <i class="calendar icon"></i>
                                <input id="searchTime1" type="text" placeholder="选择起始日期" value="">
                            </div>
                        </div>
                    </div>
                    <div class="four wide column">
                        <div class="ui myCal calendar">
                            <div class="ui icon input"><div class="ui popup calendar"><table class="ui celled center aligned unstackable table seven column day"><thead><tr><th colspan="7"><span class="link">August 2018</span><span class="prev link"><i class="chevron left icon"></i></span><span class="next link"><i class="chevron right icon"></i></span></th></tr><tr><th>S</th><th>M</th><th>T</th><th>W</th><th>T</th><th>F</th><th>S</th></tr></thead><tbody><tr><td class="link adjacent disabled">29</td><td class="link adjacent disabled">30</td><td class="link adjacent disabled">31</td><td class="link">1</td><td class="link">2</td><td class="link">3</td><td class="link">4</td></tr><tr><td class="link">5</td><td class="link">6</td><td class="link">7</td><td class="link">8</td><td class="link">9</td><td class="link">10</td><td class="link">7</td></tr><tr><td class="link">12</td><td class="link">13</td><td class="link">14</td><td class="link">15</td><td class="link">16</td><td class="link">17</td><td class="link">18</td></tr><tr><td class="link">19</td><td class="link">20</td><td class="link">21</td><td class="link today focus">22</td><td class="link">23</td><td class="link">24</td><td class="link">25</td></tr><tr><td class="link">26</td><td class="link">27</td><td class="link">28</td><td class="link">29</td><td class="link">30</td><td class="link">31</td><td class="link adjacent disabled">1</td></tr><tr><td class="link adjacent disabled">2</td><td class="link adjacent disabled">3</td><td class="link adjacent disabled">4</td><td class="link adjacent disabled">5</td><td class="link adjacent disabled">6</td><td class="link adjacent disabled">7</td><td class="link adjacent disabled">8</td></tr></tbody></table></div>
                                <i class="calendar icon"></i>
                                <input id="searchTime2" type="text" placeholder="选择结束日期" value="">
                            </div>
                        </div>
                    </div>
                    <div class="two wide column"></div>
                    <div class="two wide column">
                        <div class="ui buttons">
                            <div class="ui primary icon button" onclick="clearDate()" data-tooltip="清空">
                                <i class="ui delete icon"></i>
                            </div>
                            <div class="or"></div>
                            <div class="ui green icon button" data-tooltip="检索" onclick="searchTask()">
                                <i class="ui search icon"></i>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="ui two column doubling grid">
                    <div class="ui four wide column"></div>
                    <div class="ui four wide column">
                        <div class="ui icon input">
                            <input id="inputSearchTaskName" type="text" placeholder="搜索任务名称">
                            <i class="search icon"></i>
                        </div>
                        <div class="results"></div>
                    </div>
                    <div class="ui five wide column">
                        <select id="selectCreateTask" multiple="" class="ui fluid dropdown">
                            <option value="">选择状态</option>
                            <option value="1">草稿</option>
                            <option value="2">使用中</option>
                            <option value="3">废弃</option>
                        </select>
                    </div>
                </div>
                <br/>
            </div>
                <table class="ui left aligned sortable table">
                    <thead>
                    <tr>
                        <th>任务名称</th>
                        <th>任务状态</th>
                        <th>预期天数</th>
                        <th>创建时间</th>
                        <th>修改时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    </tbody>
                    <tfoot id="tfoot">
                    <tr>
                        <th colspan="1">
                            每页显示
                            <div class="ui compact selection dropdown hidden" tabindex="0">
                                <select id="selectPageNum">
                                    <option value="10" selected="">10</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                </select>
                                <i class="dropdown icon"></i>
                                <div class="text hidden">10</div>
                                <div class="menu hidden" tabindex="-1">
                                    <div class="item active selected hidden" data-value="10">10</div>
                                    <div class="item hidden" data-value="20">20</div>
                                    <div class="item hidden" data-value="30">30</div>
                                </div>
                            </div>
                        </th>
                        <th colspan="2"></th>
                        <th colspan="2">
                            <div class="ui pagination menu hidden">
                                <a class="item active disabled" id="pageMessage">第1页-（共1页）</a>
                                <a class="item disabled" id="previousPage">
                                    <i class="ui left chevron icon"></i>
                                </a>
                                <a class="item disabled" id="nextPage">
                                    <i class="ui right chevron icon"></i>
                                </a>
                            </div>
                        </th>
                        <th colspan="1">
                            跳转到：
                            <div class="ui compact selection dropdown hidden" tabindex="0">
                                <select id="gotoPage">
                                    <option value="1" selected="">1</option>
                                </select>
                                <i class="dropdown icon"></i>
                                <div class="text hidden">1</div>
                                <div class="menu hidden" tabindex="-1">
                                    <div class="item active selected hidden" data-value="1">1</div>
                                </div>
                            </div>
                        </th>
                    </tr>
                    </tfoot>
                </table>
        </div>

        <div class="ui bottom attached tab" data-pop="taskState2">
            <div class="ui segment">
                <div class="ui three column doubling grid">
                    <div class="two wide column"></div>
                    <div class="two wide column">
                        <h4>指定日期区间：</h4>
                    </div>
                    <div class="four wide column">
                        <div class="ui myCal calendar">
                            <div class="ui icon input"><div class="ui popup calendar"><table class="ui celled center aligned unstackable table seven column day"><thead><tr><th colspan="7"><span class="link">August 2018</span><span class="prev link"><i class="chevron left icon"></i></span><span class="next link"><i class="chevron right icon"></i></span></th></tr><tr><th>S</th><th>M</th><th>T</th><th>W</th><th>T</th><th>F</th><th>S</th></tr></thead><tbody><tr><td class="link adjacent disabled">29</td><td class="link adjacent disabled">30</td><td class="link adjacent disabled">31</td><td class="link">1</td><td class="link">2</td><td class="link">3</td><td class="link">4</td></tr><tr><td class="link">5</td><td class="link">6</td><td class="link">7</td><td class="link">8</td><td class="link">9</td><td class="link">10</td><td class="link">7</td></tr><tr><td class="link">12</td><td class="link">13</td><td class="link">14</td><td class="link">15</td><td class="link">16</td><td class="link">17</td><td class="link">18</td></tr><tr><td class="link">19</td><td class="link">20</td><td class="link">21</td><td class="link today focus">22</td><td class="link">23</td><td class="link">24</td><td class="link">25</td></tr><tr><td class="link">26</td><td class="link">27</td><td class="link">28</td><td class="link">29</td><td class="link">30</td><td class="link">31</td><td class="link adjacent disabled">1</td></tr><tr><td class="link adjacent disabled">2</td><td class="link adjacent disabled">3</td><td class="link adjacent disabled">4</td><td class="link adjacent disabled">5</td><td class="link adjacent disabled">6</td><td class="link adjacent disabled">7</td><td class="link adjacent disabled">8</td></tr></tbody></table></div>
                                <i class="calendar icon"></i>
                                <input id="searchTime2-1" type="text" placeholder="选择起始日期" value="">
                            </div>
                        </div>
                    </div>
                    <div class="four wide column">
                        <div class="ui myCal calendar">
                            <div class="ui icon input"><div class="ui popup calendar"><table class="ui celled center aligned unstackable table seven column day"><thead><tr><th colspan="7"><span class="link">August 2018</span><span class="prev link"><i class="chevron left icon"></i></span><span class="next link"><i class="chevron right icon"></i></span></th></tr><tr><th>S</th><th>M</th><th>T</th><th>W</th><th>T</th><th>F</th><th>S</th></tr></thead><tbody><tr><td class="link adjacent disabled">29</td><td class="link adjacent disabled">30</td><td class="link adjacent disabled">31</td><td class="link">1</td><td class="link">2</td><td class="link">3</td><td class="link">4</td></tr><tr><td class="link">5</td><td class="link">6</td><td class="link">7</td><td class="link">8</td><td class="link">9</td><td class="link">10</td><td class="link">7</td></tr><tr><td class="link">12</td><td class="link">13</td><td class="link">14</td><td class="link">15</td><td class="link">16</td><td class="link">17</td><td class="link">18</td></tr><tr><td class="link">19</td><td class="link">20</td><td class="link">21</td><td class="link today focus">22</td><td class="link">23</td><td class="link">24</td><td class="link">25</td></tr><tr><td class="link">26</td><td class="link">27</td><td class="link">28</td><td class="link">29</td><td class="link">30</td><td class="link">31</td><td class="link adjacent disabled">1</td></tr><tr><td class="link adjacent disabled">2</td><td class="link adjacent disabled">3</td><td class="link adjacent disabled">4</td><td class="link adjacent disabled">5</td><td class="link adjacent disabled">6</td><td class="link adjacent disabled">7</td><td class="link adjacent disabled">8</td></tr></tbody></table></div>
                                <i class="calendar icon"></i>
                                <input id="searchTime2-2" type="text" placeholder="选择结束日期" value="">
                            </div>
                        </div>
                    </div>
                    <div class="two wide column"></div>
                    <div class="two wide column">
                        <div class="ui buttons">
                            <div class="ui primary icon button" onclick="clearDate()" data-tooltip="清空">
                                <i class="ui delete icon"></i>
                            </div>
                            <div class="or"></div>
                            <div class="ui green icon button" data-tooltip="检索">
                                <i class="ui search icon"></i>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="ui two column doubling grid">
                    <div class="ui four wide column"></div>
                    <div class="ui four wide column">
                        <div class="ui icon input">
                            <input id="inputNameOrId2" type="text" placeholder="可搜索任务名称，角色、">
                            <i class="search icon"></i>
                        </div>
                        <div class="results"></div>
                    </div>
                    <div class="ui seven wide column">
                        <select name="skills" multiple="" class="ui fluid dropdown">
                            <option value="">选择状态</option>
                            <option value="angular">未开始</option>
                            <option value="css">进行中</option>
                            <option value="design">已完成</option>
                            <option value="akk">已撤回</option>
                        </select>
                    </div>
                </div>
                <br/>
            </div>
                <table class="ui left aligned sortable table">
                    <thead>
                    <tr>
                        <th>接办人</th>
                        <th>任务名称</th>
                        <th>任务状态</th>
                        <th>发放时间</th>
                        <th>计划完成时间</th>
                        <th>实际完成时间</th>
                        <th>是否逾期</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="tbody2">
                    <tr class="active">
                        <td>1-杨旭</td>
                        <td>练手系统1</td>
                        <td><font color="black">未开始</font></td>
                        <td>2018-8-22 10:28</td>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>否</td>
                        <td>
                            <a data-tooltip="撤回">
                                <i class="ui reply icon" onclick=""></i>
                            </a>
                            <a data-tooltip="详细信息" disabled="true" onclick="showStuDetail()">
                                <i class="ui list alternate outline icon"></i>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>2-徐广松</td>
                        <td>练手系统2</td>
                        <td><font color="#7fff00">进行中</font></td>
                        <td>2018-8-22 10:28</td>
                        <td>2018-9-10 00:00</td>
                        <td>N/A</td>
                        <td>否</td>
                        <td>
                            <a data-tooltip="撤回">
                                <i class="ui reply icon" onclick=""></i>
                            </a>
                            <a data-tooltip="详细信息" disabled="true" onclick="showStuDetail()">
                                <i class="ui list alternate outline icon"></i>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>1-杨旭</td>
                        <td>练手系统3</td>
                        <td><font color="aqua">已完成</font></td>
                        <td>2018-8-22 10:28</td>
                        <td>2018-9-10 00:00</td>
                        <td>2018-9-08 18:33</td>
                        <td>否</td>
                        <td>
                            <a data-tooltip="撤回">
                                <i class="ui reply icon" onclick=""></i>
                            </a>
                            <a data-tooltip="详细信息" disabled="true" onclick="showStuDetail()">
                                <i class="ui list alternate outline icon"></i>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>2-徐广松</td>
                        <td>练手系统4</td>
                        <td><font color="aqua">已完成</font></td>
                        <td>2018-8-10 10:28</td>
                        <td>2018-8-20 00:00</td>
                        <td>2018-8-22 15:16</td>
                        <td>是</td>
                        <td>
                            <a data-tooltip="撤回">
                                <i class="ui reply icon" onclick=""></i>
                            </a>
                            <a data-tooltip="详细信息" disabled="true" onclick="showStuDetail()">
                                <i class="ui list alternate outline icon"></i>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot id="tfoot2">
                    <tr>
                        <th colspan="2">
                            每页显示
                            <div class="ui compact selection dropdown hidden" tabindex="0">
                                <select id="selectPageNum2">
                                    <option value="10" selected="">10</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                </select>
                                <i class="dropdown icon"></i>
                                <div class="text hidden">10</div>
                                <div class="menu hidden" tabindex="-1">
                                    <div class="item active selected hidden" data-value="10">10</div>
                                    <div class="item hidden" data-value="20">20</div>
                                    <div class="item hidden" data-value="30">30</div>
                                </div>
                            </div>
                        </th>
                        <th colspan="2"></th>
                        <th colspan="2">
                            <div class="ui pagination menu hidden">
                                <a class="item active disabled" id="pageMessage2">第1页-（共1页）</a>
                                <a class="item disabled" id="previousPage2">
                                    <i class="ui left chevron icon"></i>
                                </a>
                                <a class="item disabled" id="nextPage2">
                                    <i class="ui right chevron icon"></i>
                                </a>
                            </div>
                        </th>
                        <th colspan="2">
                            跳转到：
                            <div class="ui compact selection dropdown hidden" tabindex="0">
                                <select id="gotoPage2">
                                    <option value="1" selected="">1</option>
                                </select>
                                <i class="dropdown icon"></i>
                                <div class="text hidden">1</div>
                                <div class="menu hidden" tabindex="-1">
                                    <div class="item active selected hidden" data-value="1">1</div>
                                </div>
                            </div>
                        </th>
                    </tr>
                    </tfoot>
                </table>

        </div>

    </div>
</div>

<div class="ui editDetails modal">
    <div class="content">
        <a class="ui big blue ribbon label">
            <i class="ui exclamation circle icon"></i>
            任务编辑页
        </a>
        <p></p>
        <div class="ui content">
            <form class="ui form" action="#" enctype="multipart/form-data">
                <div class="required field">
                    <label>任务基本信息</label>
                    <div class="two fields">
                        <div class="two wide field">
                            <label>任务名称：</label>
                            <input type="text" placeholder="少于15个字">
                        </div>
                        <div class="three wide field">
                            <label>任务时长（天）：</label>
                            <input type="number">
                        </div>
                        <div class="eleven wide field">
                            <label>任务描述：</label>
                            <input type="text" placeholder="">
                        </div>
                    </div>

                </div>

                <div class="field" id="defaultField1"></div>
                <div class="filed">
                    <div class="actions">
                        <div class="fields">
                            <div class="five wide field">
                                <input type="file" placeholder="上传附件...">
                            </div>

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="actions">
        <div class="ui deny button">取消</div>
        <div class="ui approve green button">确认</div>
    </div>
</div>

<div class="ui stuDetail mini modal">
    <div class="header">
        详细信息
    </div>
    <div class="ui content">
        <p>任务名称：恒大集团练手系统</p>
        <p>任务描述：这是一个给恒大集团新员工的练手系统</p>
        <p>预期完成时间：2018-08-24</p>
        <p>实际完成时间：N/A</p>
        <p>
            任务附件：资料.zip
            <a class="ui icon button">
                <i class="ui cloud download icon"></i>
                点击下载
            </a>
        </p>
    </div>
</div>
<div class="ui masterDetail modal">
    <div class="header">
        详细信息
    </div>
    <div class="ui content">
        <p>任务名称：恒大集团练手系统</p>
        <p>任务描述：这是一个给恒大集团新员工的练手系统</p>
        <p>反馈信息：这个任务我昨天完成的。老难了！！！</p>
    </div>
</div>

<div class="ui edit updateTask modal">
    <div class="content">
        <a class="ui big blue ribbon label">
            <i class="ui exclamation circle icon"></i>
            任务提交
        </a>
        <p></p>
        <div class="ui content">
            <form class="ui form" action="#" enctype="multipart/form-data">
                <div class="required field">
                    <label>任务基本信息</label>
                    <p>任务名称：恒大集团练手系统</p>
                    <p>任务描述：这是一个给恒大集团新员工的练手系统</p>
                    <div class="two fields">
                        <div class="three wide field">
                            提交反馈信息：
                        </div>
                        <div class="nine wide field">
                            <input type="text">
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="three wide field">
                            提交任务附件：
                        </div>
                        <div class="nine wide field">
                            <input type="file">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="actions">
        <div class="ui deny button">取消</div>
        <div class="ui approve green button">确认</div>
    </div>
</div>

<div class="ui masterPerson modal">
    <div class="header">
        查看人员
    </div>
    <div class="ui content">
        <p>任务名称：恒大集团练手系统</p>
        <p>任务描述：这是一个给恒大集团新员工的练手系统</p>
        <p>历史人员：</p>
        <table class="ui left aligned sortable table">
            <thead>
            <tr>
                <th>接办人</th>
                <th>任务状态</th>
                <th>发放时间</th>
                <th>计划完成时间</th>
                <th>实际完成时间</th>
                <th>是否逾期</th>
            </tr>
            </thead>
            <tbody id="tbodyExtra">
            <tr class="active">
                <td>1-杨旭</td>
                <td><font color="black">未开始</font></td>
                <td>2018-8-22 10:28</td>
                <td>N/A</td>
                <td>N/A</td>
                <td>否</td>
            </tr>
            <tr>
                <td>2-徐广松</td>
                <td><font color="aqua">已完成</font></td>
                <td>2018-8-10 10:28</td>
                <td>2018-8-20 00:00</td>
                <td>2018-8-22 15:16</td>
                <td>是</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<form id="searchBar1">
    <%--
    参数pageNo，第几页
    参数pageNum，每页显示多少条
    参数startDate，开始日期的检索
    参数endDate，结束日期的检索
    参数taskName，任务名的检索
    参数stateStr，任务状态筛选
    --%>
    <input id="pageNo" name="pageNo" style="display: none">
    <input id="pageNum" name="pageNum" style="display: none">
    <input id="startDate" name="startDate" style="display: none">
    <input id="endDate" name="endDate" style="display: none">
    <input id="taskName" name="taskName" style="display: none">
    <input id="stateStr" name="stateStr" style="display: none">
</form>

</body>
</html>
