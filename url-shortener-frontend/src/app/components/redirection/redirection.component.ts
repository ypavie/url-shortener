import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UrlService } from 'src/app/services/url.service';

@Component({
  selector: 'app-redirection',
  templateUrl: './redirection.component.html',
  styleUrls: ['./redirection.component.css'],
})
export class RedirectionComponent implements OnInit {
  constructor(
    private urlService: UrlService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.urlService.getOriginalUrl(id).subscribe({
        next: (response: { url: string }) => {
          this.router.navigateByUrl('/').then(() => {
            window.location.href = response.url;
          });
        },
        error: () => {
          this.router.navigateByUrl('/');
        },
      });
    } else {
      this.router.navigateByUrl('/');
    }
  }
}
