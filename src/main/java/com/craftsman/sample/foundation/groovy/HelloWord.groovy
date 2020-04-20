package com.craftsman.sample.foundation.groovy;


class WorkTime {
    def workMan = ['id'            : '1',
                   'name'          : '张三',
                   'gender'        : 'M',
                   'kind'          : 'JAVA',
                   'className'     : '1班',
                   'grade'         : 4,
                   'birth'         : '1991/11/11',
                   'address'       : '北京市',
                   'salary'        : 2000000,
                   'createTime'    : '2019/09/25',
                   'colleague'       : [
                           ['id': '1', colleagueNames: '赵柳', 'colleagueAge': 18],
                           ['id': '2', colleagueNames: '王五', 'colleagueAge': 18],
                           ['id': '3', colleagueNames: '李四', 'colleagueAge': 18],
                           ['id': '4', colleagueNames: '钱物', 'colleagueAge': 18],
                           ['id': '5', colleagueNames: '李连杰', 'colleagueAge': 18]
                   ]
    ]
    def 规则集 = [
            '基础信息':
                    [
                            '工号':workMan.id,
                            '姓名':workMan.name,
                            '是否90后': workMan.birth >= '1991/11/11'?'是':'否',
                            '性别'   : workMan.gender == 'M' ? '男' : '女',
                            '地区':{
                                def province = workMan.address.subSequence(0,3)
                                //做一个区域和省级行政单位的映射关系
                                def areaMapping = ['西南':['重庆市','四川省','贵州省','云南省'],'江浙沪':['上海市','江苏省'
                                                                                         ,'浙江省'],'京津冀':['北京市'
                                                                                                        ,'天津市','河北省']]
                                //进行筛选
                                def entry = areaMapping.find {key,value ->
                                    value.contains(province)
                                }
                                entry.key
                            }()//最后这个"()"一定要,否则闭包不执行
                    ],

            '工资'  : [
                    //使用三元表达式,大于6W --> A ,4-6W --> B,2-4W -->C,2W以下 --> D
                    '收入档次':{
                        if(workMan.salary>=20000) '高收入'
                        else if(workMan.salary>=10000) '中等收入'
                        else if(workMan.salary>=5000) '一般收入'
                        else '低收入'
                    }() //最后这个"()"一定要,否则闭包不执行
            ],
            '工作同事': [
                    '共几个':{
                        int total = 0
                        workMan.colleague.each { total ++ }
                        total
                    }(),
                    '共几岁':{
                        int total = 0
                        workMan.colleague.each { total += it.colleagueAge}
                        total
                    }(),
                    '介绍':{
                        StringBuilder desc=new StringBuilder()
                        workMan.colleague.each { desc.append(it.colleagueNames).append(",") }
                        desc.substring(0,desc.lastIndexOf(","))
                    }(),
            ]
    ]

}

//创建运行时对象
def workRule = new WorkTime()
//输出结果看
//----简单的规则取值
println "基础信息.工号  =  ${workRule.规则集.基础信息.工号}"
println "基础信息.姓名  =  ${workRule.规则集.基础信息.姓名}"
println "基础信息.是否90后  =  ${workRule.规则集.基础信息.是否90后}"
println "基础信息.性别      = ${workRule.规则集.基础信息['性别']}"
println "基础信息.地区      = ${workRule.规则集.基础信息.地区}"
println "工资.工资档次      = ${workRule.规则集.工资.收入档次}"
//----使用闭包的方式取值
println "工作同事.介绍      = ${workRule.规则集.工作同事.介绍}"
println "工作同事.共几个      = ${workRule.规则集.工作同事.共几个}"
println "工作同事.共几岁      = ${workRule.规则集.工作同事.共几岁}"
