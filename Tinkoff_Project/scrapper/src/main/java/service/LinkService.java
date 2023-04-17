package service;


import io.swagger.v3.oas.annotations.links.Link;

import java.net.URI;
import java.util.Collection;

public interface LinkService {
    Link add(long tgUserId, URI url);
    Link remove(long tgUserId, URI url);
    Collection<Link> findAllByTgUserId(long tgUserId);
}
