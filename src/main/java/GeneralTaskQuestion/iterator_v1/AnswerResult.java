package GeneralTaskQuestion.iterator_v1;

import java.util.List;

class AnswerResult {

    private List<Integer> listReturn;

    public AnswerResult(List<Integer> listReturn){
        this.listReturn = listReturn;
    }

    public List<Integer> getListReturn() {
        return listReturn;
    }

    @Override
    public String toString() {
        String answer = "[ ";
        for (Integer item : listReturn){
            answer+= item.toString() + " ";
        }
        answer += "]";

        return answer;
    }
}
