package jpabook.jpashop.controller;

import jpabook.jpashop.dto.UpdateItemDto;
import jpabook.jpashop.dto.item.CreateAlbumDto;
import jpabook.jpashop.dto.item.CreateBookDto;
import jpabook.jpashop.dto.item.CreateMovieDto;
import jpabook.jpashop.entity.item.Album;
import jpabook.jpashop.entity.item.Book;
import jpabook.jpashop.entity.item.Item;
import jpabook.jpashop.entity.item.Movie;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/new/book")
    public void cereateBook(@RequestBody CreateBookDto createBookDto) {
        Book item = new Book();
        item.setName(createBookDto.getName());
        item.setPrice(createBookDto.getPrice());
        item.setStockQuantity(createBookDto.getStockQuantity());
        item.setAuthor(createBookDto.getAuthor());
        item.setIsbn(createBookDto.getIsbn());
        itemService.saveItem(item);
    }

    @PostMapping("/item/new/album")
    public void createAlbum(@RequestBody CreateAlbumDto createAlbumDto) {
        Album item = new Album();
        item.setName(createAlbumDto.getName());
        item.setPrice(createAlbumDto.getPrice());
        item.setStockQuantity(createAlbumDto.getStockQuantity());
        item.setArtist(createAlbumDto.getArtist());
        item.setEtc(createAlbumDto.getEtc());
        itemService.saveItem(item);
    }

    @PostMapping("/item/new/movie")
    public void createMovie(@RequestBody CreateMovieDto createMovieDto) {
        Movie item = new Movie();
        item.setName(createMovieDto.getName());
        item.setPrice(createMovieDto.getPrice());
        item.setStockQuantity(createMovieDto.getStockQuantity());
        item.setDirector(createMovieDto.getDirector());
        item.setActor(createMovieDto.getActor());
        itemService.saveItem(item);
    }

    @GetMapping("/items")
    public List<Item> findItems() {
        return itemService.findItems();
    }

    @GetMapping("/item/{id}")
    public Item findItem(@PathVariable("id") Long itemId) {
        return itemService.findItem(itemId);
    }

    @PatchMapping("/item/{id}")
    public void updateItem(@PathVariable("id") Long itemId, @RequestBody UpdateItemDto updateItemDto) {
        itemService.updateItem(
                itemId,
                updateItemDto.getName(),
                updateItemDto.getPrice(),
                updateItemDto.getStockQuantity()
        );
    }
}
