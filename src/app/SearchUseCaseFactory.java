package app;

import data_access.APIDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_playlist.CreatePlaylistViewModel;
import interface_adapter.homepage.HomepageViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchViewModel;
import view.HomepageView;
import view.SearchView;

import java.io.IOException;

public class SearchUseCaseFactory {
    private SearchUseCaseFactory(){}
    // addsong usecase controller gets put in here
//    public static SearchView create(ViewManagerModel viewManagerModel,
//                                    HomepageViewModel homepageViewModel,
//                                    SearchViewModel searchViewModel,
//                                    APIDataAccessObject apiDataAccessObject){
//        try{
//            SearchController searchController = createSearchUseCase(viewManagerModel, homepageViewModel, searchViewModel, apiDataAccessObject);
//            return new HomepageView(homepageViewModel, createPlaylistViewModel, searchController, viewManagerModel);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
