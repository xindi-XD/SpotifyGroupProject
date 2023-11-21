# SpotifyGroupProject README
This programs connects to a user's Spotify account to create, delete and modify playlists.
Playlists can be named and renamed.

Updated on Nov 20th, 2023.

1. A user can search up songs, artists or genres. // API call found.

2. A user can save and unsave songs or albums to the local repository. // API call found.

3. A user can view the songs they've saved.  // Xindi did not find an API call for "saved songs", but "liked songs" might be possible.

4. A user can split up their playlists into new playlists according to artist or genre. // API call found.

5. A user can create/delete playlists.

6. A user can search up an artist and get the followers they have. // Backup 1.
7. A user can sign-in and sign-out from their account. // Backup 2.

### Views
Homepage view
- [] `<button> createPlaylist` -> jump to `<view> CreatePlaylist`
- [] `<button> deletePlaylist` -> jump to `<view> DeletePlaylist` // Could merge with ShowPlaylists tho.
- [] `<button> showPlaylists` -> jump to `<view> ShowPlaylists`
- Let's not implement search on the homepage.

CreatePlaylist view
- [] `<search_panel> search` -> jump to `<view> SearchResults`

ShowPlaylists view
- [] Displays names of all playlists.
- [] `<button> playlist_name` for every playlist -> jump to `<view> Playlist`

Playlist view
- [] Displays name of playlist, all the songs from that playlist.
- [] `<button> splitPlaylist` -> return `success/fail`, or jump to `<view> Homepage`
- [] `<button> deleteSong`
  - After every song, as a subclass
- [] `<search_panel> search` for song name -> jump to `<view> SearchResults`
  - Returns a list of songs in `<view> SearchResults`.

SearchResults view
- [] Displays top eight results from Spotify database. Each search result has `songName`, `artistName` and `albumName`.
- `<button> addSong`
  -  For each search result. The search should limit to **songs**.

## Deadlines
https://q.utoronto.ca/courses/314288/pages/project-timeline?module_item_id=5112222 for project timeline.

Nov 6th Reading week, but probably the best time to work on the project _(:з」∠)_

Nov 20th Identify remaining issues

Dec 4th Final presentation

## Plan in the long run
Views: Homepage, Playlist, 
