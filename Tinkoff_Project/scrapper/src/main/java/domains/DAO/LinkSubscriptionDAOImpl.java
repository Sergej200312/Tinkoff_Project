package domains.DAO;

import domains.LinkSubscription;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
@Repository
public class LinkSubscriptionDAOImpl implements LinkSubscriptionDAO{
    private final JdbcTemplate jdbcTemplate;

    public LinkSubscriptionDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public LinkSubscription add(LinkSubscription linkSubscription) {
        String sql = "INSERT INTO link_subscription (tgUserId, link, lastUpdate) VALUES (?, ?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, linkSubscription.getTgUserId());
            ps.setString(2, linkSubscription.getLink());
            ps.setTimestamp(3, Timestamp.valueOf(linkSubscription.getLastUpdate()));
            return ps;
        }, keyHolder);

        linkSubscription.setId(keyHolder.getKey().longValue());
        return linkSubscription;
    }

    @Override
    public void remove(long id) {
        String sql = "DELETE FROM link_subscription WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public List<LinkSubscription> findAll() {
        String sql = "SELECT * FROM link_subscription";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            LinkSubscription linkSubscription = new LinkSubscription();
            linkSubscription.setId(rs.getLong("id"));
            linkSubscription.setTgUserId(rs.getLong("tgUserId"));
            linkSubscription.setLink(rs.getString("link"));
            linkSubscription.setLastUpdate(rs.getTimestamp("lastUpdate").toLocalDateTime());
            return linkSubscription;
        });
    }
}
