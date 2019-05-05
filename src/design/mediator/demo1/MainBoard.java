package design.mediator.demo1;

public class MainBoard extends EMediator {

    public CDDevice mCdDevice;

    public CPU mCpu;

    public SoundCard mSoundCard;

    public GraphicsCard mGraphicCard;

    @Override
    public void onChanged(EColleague eColleague) {
        if (eColleague instanceof CDDevice) {

            mCpu.decodeData(mCdDevice.data);
        } else if (eColleague instanceof CPU) {
            mSoundCard.soundPlay(mCpu.dataSound);
            mGraphicCard.videoPlay(mCpu.dataVideo);

        }
    }
}
