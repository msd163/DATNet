package system;

import utils.Globals;

public class ServiceMetaInfo {

    public ServiceMetaInfo(Service service, Agent publisher, float coefficient, int forgottenBound) {
        this.service = service;
        this.publisher = publisher;   // watcher of the service
        this.coefficient = coefficient;
        this.time = Globals.WORLD_TIME;
        this.forgottenBound = forgottenBound > 0 ? forgottenBound : 1;
        //todo: [policy] : correctness level have to be calculated
        this.correctnessLevel = 1;
    }

    private Service service;
    private Agent publisher;
    private float coefficient;
    private float correctnessLevel;
    private int time;
    private int forgottenBound;

    //============================//============================//============================
    private float getForgottenValue() {
        return (float) (Globals.WORLD_TIME - time) / forgottenBound;
    }

    public float getEffectiveTrustScore() {
        return correctnessLevel * coefficient * (1 - getForgottenValue());
    }

    //============================//============================//============================
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Agent getPublisher() {
        return publisher;
    }

    public void setPublisher(Agent publisher) {
        this.publisher = publisher;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

}
