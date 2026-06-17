<?php

namespace Tests\Feature\Products;

use App\Models\Product;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Tests\TestCase;

class ProductTest extends TestCase
{
    use RefreshDatabase; // Очищает базу данных перед каждым тестом

    public function test_products_can_be_indexed(): void
    {
        Product::factory()->count(3)->create();

        $response = $this->getJson('/api/products');

        $response->assertStatus(200)->assertJsonCount(3);
    }

    public function test_product_can_be_shown(): void
    {
        $product = Product::factory()->create();

        $response = $this->getJson('/api/products/' . $product->id);

        $response->assertStatus(200)->assertJsonPath('sku', $product->sku);
    }

    public function test_product_can_be_stored(): void
    {
        $data = ['sku' => 'TEST-123', 'name' => 'Test Product', 'price' => 99.99];

        $response = $this->postJson('/api/products', $data);

        $response->assertStatus(201);
        $this->assertDatabaseHas('products', ['sku' => 'TEST-123']);
    }

    public function test_product_can_be_updated(): void
    {
        $product = Product::factory()->create();
        $data = ['name' => 'Updated Name'];

        $response = $this->putJson('/api/products/' . $product->id, $data);

        $response->assertStatus(200);
        $this->assertDatabaseHas('products', ['id' => $product->id, 'name' => 'Updated Name']);
    }

    public function test_product_can_be_destroyed(): void
    {
        $product = Product::factory()->create();

        $response = $this->deleteJson('/api/products/' . $product->id);

        $response->assertStatus(204);
        $this->assertDatabaseMissing('products', ['id' => $product->id]);
    }
}
