package bo.edu.ucb.twitter.demotwitter;
import bo.edu.ucb.twitter.demotwitter.dto.Timeline;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;
 import java.util.Collection;
 import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;


@RestController
@RequestMapping("/cache")
public class CaffeineCacheController {

    private final CacheManager cacheManager;
    private final ObjectMapper objectMapper;

    public CaffeineCacheController(final CacheManager cacheManager) {
        this.cacheManager = cacheManager;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @GetMapping("/lines")
    public Collection<String> getCacheNames() {
        return cacheManager.getCacheNames();
    }

    @GetMapping("/entries/{cacheLines}/{id}")
    public List<Timeline> getEntriesForCache(@PathVariable(name = "cacheLines") final String cacheLines, @PathVariable String id) throws JsonProcessingException,JSONException{
        final Cache<String, Object> cache = (Cache<String, Object>) cacheManager.getCache(cacheLines).getNativeCache();

        final ConcurrentMap<String, Object> data = cache.asMap();
        final String json = objectMapper.writeValueAsString(data);
        JSONObject objetoJson = new JSONObject(json);
        String json1 = objetoJson.getString(id);
        ObjectMapper mapper= new ObjectMapper();
        Timeline[] timeline = mapper.readValue(json1, Timeline[].class);
        final TypeReference<HashMap<String,Object>> typeRef = new TypeReference<>() {};
        return List.of(timeline);
    }


}