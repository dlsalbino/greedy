package br.com.azusah.greedy.framework.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Service
public class Mapper {

    public ModelMapper mapper() {
        return new ModelMapper();
    }

}
