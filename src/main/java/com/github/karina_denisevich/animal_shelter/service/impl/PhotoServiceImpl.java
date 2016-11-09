package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.model.entity.Photo;
import com.github.karina_denisevich.animal_shelter.repository.PhotoRepository;
import com.github.karina_denisevich.animal_shelter.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    @Transactional
    public Photo savePhoto(Photo photo) {
        return photoRepository.saveAndFlush(photo);
    }
}
