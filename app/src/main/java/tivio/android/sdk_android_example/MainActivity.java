package tivio.android.sdk_android_example;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;

public class MainActivity extends AppCompatActivity {

    ExoPlayer exoPlayer;
    PlayerView exoPlayerView;

    String videoURL = "https://firebasestorage.googleapis.com/v0/b/tivio-production-input-admin/o/organizations%2Fl0Q4o9TigUUTNe6TYAqR%2Fchannels%2FhL1LtUhcsZuygmi1HjJI%2Fsections%2FNQlUj81wIf0Ev6qQzRIs%2Fvideos%2F2hAoiSigTZ6Q4QyAsWAi.mp4?alt=media&token=041e129c-c034-42c5-8db0-9fb13c0e8d4e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        exoPlayerView = findViewById(R.id.idExoPlayerVIew);

        try {

            exoPlayer = new ExoPlayer.Builder(this).build();

            exoPlayerView.setPlayer(exoPlayer);

            MediaItem playableItem = MediaItem.fromUri(videoURL);
            exoPlayer.setMediaItem(playableItem);
            exoPlayer.prepare();
            exoPlayer.play();

            // Uri videouri = Uri.parse(videoURL);
        } catch (Exception e) {
            // below line is used for
            // handling our errors.
            Log.e("TAG", "Error : " + e.toString());
        }
    }
}