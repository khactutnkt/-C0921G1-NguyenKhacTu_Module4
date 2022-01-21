package vn.codegym.ss8_validatte_bai_hat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.ss8_validatte_bai_hat.model.Song;

public interface ISongRepository extends JpaRepository<Song, Long> {
}
