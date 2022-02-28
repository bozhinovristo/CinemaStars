package com.example.cinemastars.repository;

import com.example.cinemastars.model.Seat;
import com.example.cinemastars.model.SeatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, SeatId> {
    List<Seat> findAllByProjectionId(Long projectionId);
}
