package aboubakr.beastmainbroject.live;

import com.aboubakr.beastmainbroject.entities.EventPicture;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.EventPhotoServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class LivePictureService extends BaseLiveService {
    public LivePictureService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void getCommunityPictures(EventPhotoServices.SearchCommunityPhotoRequest request) {
        EventPhotoServices.SearchCommunityPhotoResponse response = new EventPhotoServices.SearchCommunityPhotoResponse();
        response.communityPhotos = new ArrayList<>();

        response.communityPhotos.add(new EventPicture("http://lorempixel.com/400/400/people/1"));
        response.communityPhotos.add(new EventPicture("http://lorempixel.com/400/400/people/2"));
        response.communityPhotos.add(new EventPicture("http://lorempixel.com/400/400/people/3"));

        bus.post(response);
    }

    @Subscribe
    public void getBrotherhoodPictures(EventPhotoServices.SearchBrotherHoodPhotoRequest request) {
        EventPhotoServices.SearchBrotherHoodPhotoResponse response = new EventPhotoServices.SearchBrotherHoodPhotoResponse();
        response.brotherHoodPhotos = new ArrayList<>();

        response.brotherHoodPhotos.add(new EventPicture("http://lorempixel.com/400/400/sports/1"));
        response.brotherHoodPhotos.add(new EventPicture("http://lorempixel.com/400/400/sports/2"));
        response.brotherHoodPhotos.add(new EventPicture("http://lorempixel.com/400/400/sports/3"));

        bus.post(response);
    }

    @Subscribe
    public void getSocialPictures(EventPhotoServices.SearchSocialPhotoRequest request) {
        EventPhotoServices.SearchSocialPhotoResponse response = new EventPhotoServices.SearchSocialPhotoResponse();
        response.socialPhotos = new ArrayList<>();

        response.socialPhotos.add(new EventPicture("http://lorempixel.com/400/400/nature/1"));
        response.socialPhotos.add(new EventPicture("http://lorempixel.com/400/400/nature/2"));
        response.socialPhotos.add(new EventPicture("http://lorempixel.com/400/400/nature/3"));

        bus.post(response);
    }
}
