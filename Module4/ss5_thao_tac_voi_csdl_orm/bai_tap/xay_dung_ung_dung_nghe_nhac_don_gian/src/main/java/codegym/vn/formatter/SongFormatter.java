package codegym.vn.formatter;

import codegym.vn.entity.Song;
import codegym.vn.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class SongFormatter implements Formatter<Song> {
    private SongService songService;
    @Autowired
    public SongFormatter(SongService songService) {
        this.songService = songService;
    }

    @Override
    public Song parse(String text, Locale locale) throws ParseException {
        return songService.findById(text);
    }

    @Override
    public String print(Song object, Locale locale) {
        return object.toString();
    }
}
