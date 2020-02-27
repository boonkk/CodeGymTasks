package com.codegym.task.task24.task2405;

/* 
Black box

*/
public class Solution implements Action {
    public static int actionObjectCount;

    private int param;

    private Action solutionAction = new Action() {

        public void someAction() {
            if(param>0) {
                new FirstClass() {
                    @Override
                    public Action getDependentAction() {
                        for(;param>0;param--) {
                            System.out.println(param);
                        }
                        super.someAction();
                        SecondClass secondClass = new SecondClass();
                        secondClass.someAction();
                        return secondClass;
                    }
                }.getDependentAction();
            } else {
                new SecondClass().someAction();
            }
            System.out.println(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.substring(1) + param);

        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * FirstClass class, someAction method
     * SecondClass class, someAction method
     * Specific action for anonymous SecondClass, param = 0
     * The number of created Action objects is 2
     * SecondClass class, someAction method
     * Specific action for anonymous SecondClass, param = -1
     * The number of created Action objects is 3
     */

    /*
    5
    4
    3
    2
    1
    FirstClass class, someAction method
    SecondClass class, someAction method
pecific action for anonymous SecondClass, param = 0
The number of created Action objects is 2
SecondClass class, someAction method
pecific action for anonymous SecondClass, param = -1
    The number of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("The number of created Action objects is " + actionObjectCount);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("The number of created Action objects is " + actionObjectCount);
    }
}
